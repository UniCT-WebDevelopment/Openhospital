package com.openhospital.productservice.exceptions;

import com.openhospital.productservice.beans.Result;
import com.openhospital.productservice.constants.ReturnCodes;
import lombok.ToString;

@ToString
public class ApplicationException extends Exception {
	
	private static final long serialVersionUID = 2708079975917465159L;
	
	private String message;
	private Result exceptionCause;
	
	protected ApplicationException() {}
	
	public ApplicationException(String message, ReturnCodes returnCode) {
		this.message = message;
		this.exceptionCause = new Result(returnCode);
	}

	public ApplicationException(String message, Result exceptionCause) {
		this.message = message;
		this.exceptionCause = exceptionCause;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Result getExceptionCause() {
		return exceptionCause;
	}

	public void setExceptionCause(Result exceptionCause) {
		this.exceptionCause = exceptionCause;
	}

}
