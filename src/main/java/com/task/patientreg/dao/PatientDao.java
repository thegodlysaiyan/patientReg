package com.task.patientreg.dao;

import com.task.patientreg.dto.Patientdto;

public interface PatientDao {
	
public void openConnection();
	
	public Patientdto getPatientById(String patientId);
	
	
	
	public void closeConnection();

	public Patientdto savePatient(Patientdto patientdto);


}
