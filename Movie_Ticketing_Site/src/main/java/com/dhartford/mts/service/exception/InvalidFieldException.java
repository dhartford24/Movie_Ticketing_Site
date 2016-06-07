package com.dhartford.mts.service.exception;

@SuppressWarnings("serial")
public class InvalidFieldException extends MTSException {

	public InvalidFieldException(String message, Throwable throwable) {
		super(ErrorCode.INVALID_FIELD, message, throwable);
	}
	
	public InvalidFieldException(String message) {
		super(ErrorCode.INVALID_FIELD, message);
	}
}
