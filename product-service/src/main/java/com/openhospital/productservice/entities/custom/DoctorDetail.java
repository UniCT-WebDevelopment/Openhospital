package com.openhospital.productservice.entities.custom;

import java.math.BigDecimal;

public interface DoctorDetail {

	public Integer getId();
	
	public String getName();
	
	public String getSurname();

	public String getEmail();

	public String getMobilePhone();

	public String getOfficePhone();

	public String getWardCode();

	public String getWardDescription();

	public BigDecimal getPrice();
	
}
