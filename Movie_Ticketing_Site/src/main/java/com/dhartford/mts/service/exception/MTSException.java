package com.dhartford.mts.service.exception;

@SuppressWarnings("serial")
public class MTSException extends RuntimeException {

	private ErrorCode errorCode;

	public MTSException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public MTSException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
