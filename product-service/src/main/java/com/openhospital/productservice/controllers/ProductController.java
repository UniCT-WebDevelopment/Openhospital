package com.openhospital.productservice.controllers;


import com.openhospital.productservice.beans.Result;
import com.openhospital.productservice.beans.proposals.get.GetProposalsInput;
import com.openhospital.productservice.beans.proposals.get.GetProposalsOutput;
import com.openhospital.productservice.beans.proposals.lock.InputProposal;
import com.openhospital.productservice.beans.proposals.lock.LockProposalsInput;
import com.openhospital.productservice.beans.proposals.lock.LockProposalsOutput;
import com.openhospital.productservice.beans.proposals.lock.OutputReservation;
import com.openhospital.productservice.beans.reservations.buy.BuyReservationsInput;
import com.openhospital.productservice.beans.reservations.buy.BuyReservationsOutput;
import com.openhospital.productservice.beans.reservations.buy.InputReservation;
import com.openhospital.productservice.beans.wards.GetWardsInput;
import com.openhospital.productservice.beans.wards.GetWardsOutput;
import com.openhospital.productservice.constants.*;
import com.openhospital.productservice.entities.Proposal;
import com.openhospital.productservice.entities.Reservation;
import com.openhospital.productservice.exceptions.ApplicationException;
import com.openhospital.productservice.repositories.ProposalRepository;
import com.openhospital.productservice.repositories.ReservationRepository;
import com.openhospital.productservice.services.DoctorService;
import com.openhospital.productservice.services.HealthService;
import com.openhospital.productservice.services.WardService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Log4j2
@RestController
@ControllerAdvice

@RequestMapping(value = "/product-service/v1", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	HealthService healthService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	WardService wardService;

	@Autowired
	ProposalRepository proposalRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping(value = "/getProposals", method = { RequestMethod.POST })
	public ResponseEntity<GetProposalsOutput> getProposals(@RequestBody GetProposalsInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - getProposals");

		GetProposalsOutput getProposalsOutput = new GetProposalsOutput();
		getProposalsOutput.setResult(new Result(ReturnCodes.OK));

		if (req.getWardCode() == null || req.getWardCode().isBlank()) {
			getProposalsOutput.setResult(new Result(ReturnCodes.WARDCODE_NOT_VALID));
		}

		if (req.getLang() == null || !EnumUtils.isValidEnum(Lang.class, req.getLang().toUpperCase())) {
			getProposalsOutput.setResult(new Result(ReturnCodes.LANGUAGE_NOT_VALID));
		}


		if (getProposalsOutput.getResult().getCode().equals(ReturnCodes.OK.getCode())) {
			if (ProductType.HEALTH.name().equalsIgnoreCase(req.getProductType())) {
				if (req.getCheckIn() == null || req.getCheckIn().isBlank()) {
					getProposalsOutput.setResult(new Result(ReturnCodes.MISSING_PARAMETERS));
				} else {
					try {
						Instant.parse(req.getCheckIn());
						getProposalsOutput = healthService.getProposals(req);
					} catch (DateTimeParseException e) {
						getProposalsOutput.setResult(new Result(ReturnCodes.CHECKIN_NOT_VALID));
					}
				}

			} else if (ProductType.DOCTOR.name().equalsIgnoreCase(req.getProductType())) {
				getProposalsOutput = doctorService.getProposals(req);

			} else {
				getProposalsOutput.setResult(new Result(ReturnCodes.PRODUCTTYPE_NOT_VALID));
			}
		}

		log.debug("END - getProposals");

		return new ResponseEntity<GetProposalsOutput>(getProposalsOutput, HttpStatus.OK);
	}


	@RequestMapping(value = "/lockProposals", method = { RequestMethod.POST })
	public ResponseEntity<LockProposalsOutput> lockProposals(@RequestBody LockProposalsInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - lockProposals");

		LockProposalsOutput lockProposalsOutput = new LockProposalsOutput();

		if (req.getProposals() == null || req.getProposals().size() == 0) {
			lockProposalsOutput.setResult(new Result(ReturnCodes.MISSING_PARAMETERS));
		} else {

			for (InputProposal inputProposal : req.getProposals()) {
				Optional<Proposal> proposalToLock = proposalRepository.findById((int) inputProposal.getProposalId());

				if (proposalToLock == null || proposalToLock.isEmpty()) {
					lockProposalsOutput.setResult(new Result(ReturnCodes.PROPOSALID_NOT_FOUND));
					break;

				} else {
					Proposal proposal = proposalToLock.get();

					if (proposal.getStatus().equals(AccessStatus.FREE.getCode())) {
						// Create reservation and update proposal
						Reservation reservation = writeReservation(proposal, inputProposal);
						OutputReservation outputReservation = new OutputReservation();
						outputReservation.setProposalId(BigDecimal.valueOf(proposal.getId()));
						outputReservation.setReservationId(BigDecimal.valueOf(reservation.getId()));

						proposal.setStatus(AccessStatus.LOCKED.getCode());
						proposal.setUpdateTimestamp(Instant.now());

						proposalRepository.save(proposal);
						proposalRepository.flush();

						lockProposalsOutput.addReservationsItem(outputReservation);
						lockProposalsOutput.setResult(new Result(ReturnCodes.OK));

					} else {
						lockProposalsOutput.setResult(new Result(ReturnCodes.STATUS_NOT_VALID));
						break;
					}
				}
			}

			// Remove reservations if result is not valid
			if (lockProposalsOutput.getResult().getCode().equals(ReturnCodes.OK)) {
				lockProposalsOutput.setReservations(null);
			}
		}

		log.debug("END - lockProposals");

		return new ResponseEntity<LockProposalsOutput>(lockProposalsOutput, HttpStatus.OK);
	}


	@RequestMapping(value = "/buyReservations", method = { RequestMethod.POST })
	public ResponseEntity<BuyReservationsOutput> buyReservations(@RequestBody BuyReservationsInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - buyReservations");

		BuyReservationsOutput buyReservationsOutput = new BuyReservationsOutput();

		if (req.getReservations() == null || req.getReservations().size() == 0) {
			buyReservationsOutput.setResult(new Result(ReturnCodes.MISSING_PARAMETERS));
		} else {

			for (InputReservation inputReservation : req.getReservations()) {
				Optional<Reservation> reservationToBuy = reservationRepository.findById((int) inputReservation.getReservationId());

				if (reservationToBuy == null || reservationToBuy.isEmpty()) {
					buyReservationsOutput.setResult(new Result(ReturnCodes.RESERVATION_ID_NOT_FOUND));
					break;

				} else {
					Reservation reservation = reservationToBuy.get();

					Optional<Proposal> proposalToBuy = proposalRepository.findById(reservation.getProposal().getId());

					if (proposalToBuy == null || proposalToBuy.isEmpty()) {
						buyReservationsOutput.setResult(new Result(ReturnCodes.PROPOSALID_NOT_FOUND));
						break;

					} else {
						Proposal proposal = proposalToBuy.get();

						if (proposal.getStatus().equals(AccessStatus.LOCKED.getCode()) && reservation.getStatus().equals(ReservationStatus.LOCKED.getCode())) {

							proposal.setStatus(AccessStatus.BOUGHT.getCode());
							proposal.setUpdateTimestamp(Instant.now());
							proposalRepository.save(proposal);
							proposalRepository.flush();

							reservation.setStatus(ReservationStatus.BOUGHT.getCode());
							reservation.setUpdateTimestamp(Instant.now());
							reservationRepository.save(reservation);
							reservationRepository.flush();

							buyReservationsOutput.setResult(new Result(ReturnCodes.OK));

						} else {
							buyReservationsOutput.setResult(new Result(ReturnCodes.STATUS_NOT_VALID));
							break;
						}
					}
				}

			}
		}

		log.debug("END - buyReservations");

		return new ResponseEntity<BuyReservationsOutput>(buyReservationsOutput, HttpStatus.OK);
	}


	@RequestMapping(value = "/getWards", method = { RequestMethod.POST })
	public ResponseEntity<GetWardsOutput> getWards(@RequestBody GetWardsInput req)
			throws ApplicationException {

		log.debug("START - getWards");

		GetWardsOutput wardsOutput = new GetWardsOutput();

		if (req.getLang() == null || !EnumUtils.isValidEnum(Lang.class, req.getLang().toUpperCase())) {
			wardsOutput.setResult(new Result(ReturnCodes.LANGUAGE_NOT_VALID));
		} else {
			wardsOutput = wardService.getWards(req);
		}

		log.debug("END - getWards");

		return new ResponseEntity<GetWardsOutput>(wardsOutput, HttpStatus.OK);
	}

	private Reservation writeReservation(Proposal proposal, InputProposal inputProposal) {
		Reservation reservation = new Reservation();
		reservation.setId(reservationRepository.getNextValSequence());
		reservation.setPrice(proposal.getPrice());
		reservation.setProductType(proposal.getProductType());
		reservation.setProductCode(proposal.getProductCode());
		reservation.setStatus(ReservationStatus.LOCKED.getCode());
		reservation.setCheckIn(proposal.getCheckIn());
		reservation.setProposal(proposal);
		reservation.setEmail(inputProposal.getEmail());
		reservation.setName(inputProposal.getName());
		reservation.setSurname(inputProposal.getSurname());
		reservation.setInsertTimestamp(Instant.now());
		reservation.setUpdateTimestamp(Instant.now());

		reservationRepository.save(reservation);
		reservationRepository.flush();

		return reservation;
	}

}