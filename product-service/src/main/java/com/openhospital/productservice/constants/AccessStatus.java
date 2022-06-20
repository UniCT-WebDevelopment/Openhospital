package com.openhospital.productservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum AccessStatus {
	LOCKED("L","Locked"),
	BOUGHT("B","Bought"),
	FREE("F","Free"),
	CANCELLED("C","Cancelled"),
	UNLOCKED("U","Unlocked"),
	RESERVED("R","Reserved"), 
	SUBSTITUTED("S","Substituted")
	;
	
	private final String code;
	private final String description;

}
