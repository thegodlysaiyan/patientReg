package com.task.patientreg.service;

import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.exception.InvalidRequestException;

public interface PatientService {
	
	public Patientdto getPatientByPatientId(String patientId);
	public Patientdto createPatient(Patientdto patientdto) throws InvalidRequestException;

}
