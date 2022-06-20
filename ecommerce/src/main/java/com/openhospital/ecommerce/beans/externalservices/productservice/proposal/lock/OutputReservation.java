package com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * OutputReservation
 */
@Data
@ToString
public class OutputReservation {

	private BigDecimal reservationId = null;
	private BigDecimal proposalId = null;
  
}