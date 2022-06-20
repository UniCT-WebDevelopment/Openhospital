package com.openhospital.userservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum ReturnCodes {

	OK("000", "Operation successfully terminated", true),
	GENERIC_ERROR("001", "Generic error", false),
	OP_NOT_PERMITTED("002", "Operation not permitted", false),
	MISSING_PARAMETERS("003", "Missing parameters", false),
	USER_NOT_FOUND("004", "User not valid", false),
	USER_ALREADY_EXIST("005", "User already exist", false),
	USER_STATUS_NOT_FOUND("006", "User status not valid", false)
	;
	
	private final String code;
	private final String description;
	private final boolean validResponse;

}
