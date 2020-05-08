package com.task.patientreg.database;

import java.util.HashMap;
import java.util.Map;

import com.task.patientreg.model.request.RegistrationRequest;
public class DatabaseClass {
	
	private static Map<Integer, RegistrationRequest> patients = new HashMap<>();
	 
	public static Map<Integer, RegistrationRequest> getPatients() {
		return patients;
	}

}
