package com.openhospital.ecommerce.beans.externalservices.productservice.ward;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Ward
 */
@Data
@ToString
public class Ward {

	private BigDecimal wardId = null;
	private String wardCode;
	private String wardDescription;
	private String lang;
  
}