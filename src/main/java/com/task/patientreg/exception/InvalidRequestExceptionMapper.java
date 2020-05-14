package com.task.patientreg.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.task.patientreg.model.response.ErrorMessages;
import com.task.patientreg.model.response.ErrorResponse;





@Provider
public class InvalidRequestExceptionMapper implements ExceptionMapper<InvalidRequestException>{
	
public Response toResponse(InvalidRequestException exception) {
		
		ErrorResponse error= new ErrorResponse(exception.getMessage(), 
		ErrorMessages.INVALID_FIELD.name(), "http://documentation.errordetials.com");
		
		return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
	}

}
