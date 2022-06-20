package com.openhospital.ecommerce.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter

public enum OrderStatus {

	INITIALIZED("I","Initialized", "not-completed"),
	LOCKED("L","Locked", "not-completed"),
	BOUGHT("B","Bought", "completed"),
	PAYED("P","Payed", "completed"),
	CANCELLED("C","Cancelled", "cancelled"),
	INVOICE_GENERATED("IG","Invoice-generated", "completed"),
	TICKET_GENERATED("TG","E-ticket-generated", "completed"),
	MODIFIED("M","Modified", "modified")
	;
	
	private final String code;
	private final String description;
	private final String userDescription;

	// Method used to retrieve enum object passing the code
	public static OrderStatus findObjectByCode(String orderStatus) {
		try {
			return Arrays.stream(OrderStatus.values()).filter(v ->
			    v.getCode().equals(orderStatus)).findFirst().orElseThrow(() ->
			    new Exception(String.format("Unknown OrderStatus.code: '%s'", orderStatus)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
