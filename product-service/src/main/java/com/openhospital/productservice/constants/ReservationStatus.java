package com.openhospital.productservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter

public enum ReservationStatus {

	LOCKED("L","Locked"),
	BOUGHT("B","Bought"),
	FREE("F","Free"),
	CANCELLED("C","Cancelled"),
	UNLOCKED("U","Unlocked"),
	RESERVED("R","Reserved"),
	SUBSTITUTED("S","Substituted"),
	MODIFIED("M","Modified")
	;
	
	private final String code;
	private final String description;

	// Method used to retrieve enum value passing the code (which we get from every single reservationAccess)
	public static ReservationStatus findValueByCode(String accessStatus) {
		try {
			return Arrays.stream(ReservationStatus.values()).filter(v ->
			    v.getCode().equals(accessStatus)).findFirst().orElseThrow(() ->
			    new Exception(String.format("Unknown ReservationStatus.code: '%s'", accessStatus)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
