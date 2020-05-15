package com.task.patientreg.exception;

import com.task.patientreg.model.response.ErrorMessages;
import com.task.patientreg.model.response.ErrorResponse;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoPatientFoundExceptionMapper implements ExceptionMapper<NoPatientFoundException>{

	@Override
	public Response toResponse(NoPatientFoundException exception) {
		// TODO Auto-generated method stub
		ErrorResponse error= new ErrorResponse(exception.getMessage(), 
		ErrorMessages.NO_PATIENT_FOUND.name(), "http://documentation.errordetials.com");
		
		return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
	}

}
