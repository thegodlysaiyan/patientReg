package com.task.patientreg.exception;

public class NoPatientFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -2856989992294756441L;
	
	public NoPatientFoundException(String message) {
		super(message);
	}

}
