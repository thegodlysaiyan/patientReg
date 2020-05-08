package com.task.patienreg.dao;

import com.task.patienreg.dto.Patientdto;

public interface PatientDao {
	
public void openConnection();
	
	public Patientdto getBookingById(long patientId);
	
	
	
	public void closeConnection();

	public Patientdto savePatient(Patientdto patientdto);


}
