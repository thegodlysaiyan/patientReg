package com.task.patientreg.service;

import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.exception.InvalidRequestException;
import com.task.patientreg.exception.NoPatientFoundException;

public interface PatientService {
	
	public Patientdto getPatientByPatientId(String patientId) throws NoPatientFoundException;
	public Patientdto createPatient(Patientdto patientdto) throws InvalidRequestException;

}
