package com.zillion.api.palicount.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFound implements ExceptionMapper<DataNotFoundException> {
	@Override
	public Response toResponse(DataNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage(404, e.getMessage());
		return Response.status(Status.NOT_FOUND)
				.type(MediaType.APPLICATION_JSON)
				.entity(errorMessage.toString()).build();
	}
}