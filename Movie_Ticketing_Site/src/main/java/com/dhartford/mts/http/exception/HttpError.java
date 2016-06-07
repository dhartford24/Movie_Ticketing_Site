package com.dhartford.mts.http.exception;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.dhartford.mts.service.exception.MTSException;

@XmlRootElement(name = "error")
public class HttpError {
	
	@XmlElement
	public int status;
	
	@XmlElement
	public String code;
	
	@XmlElement
	public String message;
	
	@XmlElement
	public String debug;

	public HttpError(){}
	
	public HttpError(MTSException ex) {
		status=409;
		code=ex.getErrorCode()==null?"":ex.getErrorCode().name();
		message=ex.getMessage();
		debug=ex.getCause()==null?"":"caused by"+ex.getCause().getMessage();		
	}

}
