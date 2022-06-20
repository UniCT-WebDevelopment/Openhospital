package com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.openhospital.ecommerce.utils.DateUtils;
import lombok.Data;
import lombok.ToString;

/**
 * OutputProposal
 */
@Data
@ToString
public class OutputProposal {

	private BigDecimal proposalId = null;
	private String productType;
	private String productCode;
	private String productDescription;
	private String wardCode;
	private String wardDescription;
	private String mobilePhone;
	private String officePhone;
	private String checkIn;
	private BigDecimal price = null;
	private BigDecimal availablePlaces = null;
	private BigDecimal maxQuantity = null;
  
}