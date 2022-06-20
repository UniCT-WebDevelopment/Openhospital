package com.openhospital.productservice.services;

import com.openhospital.productservice.beans.Result;
import com.openhospital.productservice.beans.proposals.get.GetProposalsInput;
import com.openhospital.productservice.beans.proposals.get.GetProposalsOutput;
import com.openhospital.productservice.beans.proposals.get.OutputProposal;
import com.openhospital.productservice.constants.AccessStatus;
import com.openhospital.productservice.constants.ProductType;
import com.openhospital.productservice.constants.ReturnCodes;
import com.openhospital.productservice.entities.Proposal;
import com.openhospital.productservice.entities.custom.HealthDetail;
import com.openhospital.productservice.exceptions.ApplicationException;
import com.openhospital.productservice.repositories.HealthRepository;
import com.openhospital.productservice.repositories.ProposalRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Log4j2
@Configuration
@Service
public class HealthService {

	@Autowired
	HealthRepository healthRepository;

	@Autowired
	ProposalRepository proposalRepository;

	public GetProposalsOutput getProposals(GetProposalsInput req) throws ApplicationException
	{
		GetProposalsOutput out = new GetProposalsOutput();
		out.setResult(new Result(ReturnCodes.OK));

		log.info("BEGIN PROPOSALS GENERATION");

		List<HealthDetail> healthDetails = healthRepository.getHealthByWardCodeAndLang(req.getWardCode(), req.getLang());

		for (HealthDetail healthDetail : healthDetails) {
			OutputProposal proposalOutput = new OutputProposal();
			proposalOutput.setProposalId(BigDecimal.valueOf(proposalRepository.getNextValSequence()));
			proposalOutput.setPrice(healthDetail.getPrice());
			proposalOutput.setProductType(ProductType.HEALTH.name());
			proposalOutput.setProductCode(String.valueOf(healthDetail.getId()));
			proposalOutput.setProductInformations(healthDetail.getHealthInfo());
			proposalOutput.setProductDescription(healthDetail.getHealthDescription());
			proposalOutput.setWardCode(healthDetail.getWardCode());
			proposalOutput.setWardDescription(healthDetail.getWardDescription());
			proposalOutput.setCheckIn(req.getCheckIn());
			proposalOutput.setAvailablePlaces(BigDecimal.valueOf(20));
			proposalOutput.setMaxQuantity(BigDecimal.valueOf(1));

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
		proposal.setCheckIn(Instant.parse(proposalOutput.getCheckIn()));
		proposal.setStatus(AccessStatus.FREE.getCode());
		proposal.setInsertTimestamp(Instant.now());
		proposal.setUpdateTimestamp(Instant.now());

		proposalRepository.save(proposal);
		proposalRepository.flush();
	}

}