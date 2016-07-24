package com.zillion.api.palicount.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidRequestException implements ExceptionMapper<Throwable> {
	private final String message = "Bad/Invalid Request, please check the path and parameters in your call";

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage errorMessage = new ErrorMessage(400, message);
		return Response.status(Status.BAD_REQUEST)
				.type(MediaType.APPLICATION_JSON)
				.entity(errorMessage.toString()).build();
	}
}
