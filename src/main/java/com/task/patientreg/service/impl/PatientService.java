package com.task.patientreg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.task.patientreg.database.DatabaseClass;
import com.task.patientreg.model.request.RegistrationRequest;

public class PatientService {
	
	private Map<Integer, RegistrationRequest> patients = DatabaseClass.getPatients();
	
	public PatientService() {
//		patients.put(1, new RegistrationRequest("1","6ft 2inch","80Kg","85C","180/120","50.5", "80"));
//		patients.put(2, new RegistrationRequest("2","5ft 9inch","65Kg","82C","170/110","45.5", "90"));
	}
	
	public List<RegistrationRequest> getAllPatients(){
		return  new ArrayList<RegistrationRequest>(patients.values());
		
	}
	public RegistrationRequest getPatient(int id) {
		return patients.get(id);
	}
	public RegistrationRequest addPatient(RegistrationRequest request) {
//		request.setId(Integer.toString(patients.size() + 1));
//		patients.put(Integer.parseInt(request.getId()), request);
		return request;
	}
	

}
