package com.openhospital.productservice.services;

import com.openhospital.productservice.beans.*;
import com.openhospital.productservice.beans.proposals.get.GetProposalsInput;
import com.openhospital.productservice.beans.proposals.get.GetProposalsOutput;
import com.openhospital.productservice.beans.proposals.get.OutputProposal;
import com.openhospital.productservice.constants.*;
import com.openhospital.productservice.entities.Proposal;
import com.openhospital.productservice.entities.custom.DoctorDetail;
import com.openhospital.productservice.exceptions.ApplicationException;
import com.openhospital.productservice.repositories.DoctorRepository;
import com.openhospital.productservice.repositories.ProposalRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Log4j2
@Configuration
@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	ProposalRepository proposalRepository;

	public GetProposalsOutput getProposals(GetProposalsInput req) throws ApplicationException {
		GetProposalsOutput out = new GetProposalsOutput();
		out.setResult(new Result(ReturnCodes.OK));

		log.info("BEGIN PROPOSALS GENERATION");
		//OutputProposal proposal = new OutputProposal();

		List<DoctorDetail> doctorDetails = doctorRepository.getDoctorByWardCodeDoctorNameAndLang(req.getWardCode(), req.getDoctor(), req.getLang());

		for (DoctorDetail doctorDetail : doctorDetails) {
			OutputProposal proposalOutput = new OutputProposal();
			proposalOutput.setProposalId(BigDecimal.valueOf(proposalRepository.getNextValSequence()));
			proposalOutput.setPrice(doctorDetail.getPrice());
			proposalOutput.setProductType(ProductType.DOCTOR.name());
			proposalOutput.setProductCode(String.valueOf(doctorDetail.getId()));
			//proposalOutput.setProductCode("CH-001");
			proposalOutput.setProductDescription(doctorDetail.getSurname() + " " + doctorDetail.getName());
			proposalOutput.setWardCode(doctorDetail.getWardCode());
			proposalOutput.setWardDescription(doctorDetail.getWardDescription());
			proposalOutput.setMobilePhone(doctorDetail.getMobilePhone());
			proposalOutput.setOfficePhone(doctorDetail.getOfficePhone());
			//proposalOutput.setAvailablePlaces(BigDecimal.valueOf(20));
			//proposalOutput.setMaxQuantity(BigDecimal.valueOf(1));

			writeProposal(proposalOutput);
			out.addProposalsItem(proposalOutput);
		}

		log.debug("getProposals: " + out.toString());

		return out;
	}

	private void writeProposal(OutputProposal proposalOutput) {
		Proposal proposal = new Proposal();
		proposal.setId(proposalOutput.getProposalId().intValue());
		proposal.setPrice(proposalOutput.getPrice());
		proposal.setProductType(proposalOutput.getProductType());
		proposal.setProductCode(proposalOutput.getProductCode());
		proposal.setStatus(AccessStatus.FREE.getCode());
		proposal.setInsertTimestamp(Instant.now());
		proposal.setUpdateTimestamp(Instant.now());

		proposalRepository.save(proposal);
		proposalRepository.flush();
	}
}
