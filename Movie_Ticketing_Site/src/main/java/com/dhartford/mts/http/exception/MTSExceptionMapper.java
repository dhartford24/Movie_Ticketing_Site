package com.dhartford.mts.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.dhartford.mts.service.exception.MTSException;

@Provider
@Component
public class MTSExceptionMapper implements ExceptionMapper<MTSException>{

	@Override
	public Response toResponse(MTSException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}
}
