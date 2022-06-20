package com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * InputProposal
 */
@Data
@ToString
public class InputProposal {

	private BigDecimal proposalId = null;
	private String name;
	private String surname;
	private String email;
  
}