package com.openhospital.ecommerce.beans.externalservices.userservice.get;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

/**
 * OutputUser
 */
@Data
@ToString
public class OutputUser {

	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String taxCode;
	private String country;
	private String city;
	private String province;
	private String postCode;
	private String address;
	private String addressNumber;
	private String phone;
	private Boolean consent1 = false;
	private Boolean consent2 = false;
	private Boolean consent3 = false;
	private Instant insertTimestamp;
	private Instant updateTimestamp;
	private String userType;
	private Boolean enabled = false;
}