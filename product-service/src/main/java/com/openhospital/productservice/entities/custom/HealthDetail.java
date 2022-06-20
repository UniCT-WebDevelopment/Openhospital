package com.openhospital.productservice.entities.custom;

import java.math.BigDecimal;

public interface HealthDetail {

	public Integer getId();
	
	public String getWardCode();

	public String getWardDescription();

	public String getHealthDescription();

	public String getHealthInfo();
	
	public BigDecimal getPrice();
	
}
