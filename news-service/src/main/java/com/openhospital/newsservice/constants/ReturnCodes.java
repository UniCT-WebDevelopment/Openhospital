package com.openhospital.newsservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum ReturnCodes {

	OK("000", "Operation successfully terminated", true),
	GENERIC_ERROR("001", "Generic error", false),
	OP_NOT_PERMITTED("002", "Operation not permitted", false),
	MISSING_PARAMETERS("003", "Missing parameters", false),
	PRODUCTTYPE_NOT_VALID("004", "Product type not valid", false),
	CHECKIN_NOT_VALID("005", "Check-in date not valid", false),
	WARDCODE_NOT_VALID("006", "Ward code not valid", false),
	LANGUAGE_NOT_VALID("007", "Language not valid", false),
	PROPOSALID_NOT_VALID("008", "Proposal ID not valid", false),
	PROPOSALID_NOT_FOUND("009", "Proposal ID not found", false),
	QUANTITY_NOT_AVAILABLE("010", "Quantity not available", false),
	SEQUENCE_NUMBER_NOT_VALID("011", "Sequence number not valid", false),
	SEQUENCE_NUMBER_NOT_FOUND("012", "Sequence number not found", false),
	RESERVATION_ID_NOT_VALID("013", "Reservation ID not valid", false),
	RESERVATION_ID_NOT_FOUND("014", "Reservation ID not found", false),
	PROPOSALS_NOT_AVAILABLE("015", "Proposals not available", false),
	STATUS_NOT_VALID("016", "Status not valid", false),
	NO_SLOTS_AVAILABLE("017", "No slots available", false),
	RESERVATION_ALREADY_BOUGHT("018", "Reservation already bought", false)
	;
	
	private final String code;
	private final String description;
	private final boolean validResponse;

}
