package com.openhospital.ecommerce.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum PaymentMethod {

	CREDIT_CARD("cc"),
	PAYPAL("paypal"),
	BANK_TRANSFER("bankTransfer")
	;

	private final String code;

	public static PaymentMethod findByCode(String code) {
		PaymentMethod result = null;
		for (PaymentMethod method : values()) {
			if (method.getCode().equalsIgnoreCase(code)) {
				result = method;
				break;
			}
		}
		return result;
	}
}
