package com.task.patientreg.model.response;

public enum ErrorMessages {
	
	INVALID_FIELD("Invalid field value. Please check documentation"),
	INTERNAL_SERVER_ERROR("Internal Server error"),
	NO_PATIENT_FOUND("Patient with entered Id is not present");
	
	private String errormessage;

	private ErrorMessages(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	

}
