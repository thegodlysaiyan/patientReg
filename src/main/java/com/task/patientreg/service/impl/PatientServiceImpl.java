package com.task.patientreg.service.impl;


import java.util.List;
import java.util.Map;

import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dao.impl.Patientdaoimpl;
import com.task.patientreg.database.DatabaseClass;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.model.request.RegistrationRequest;
import com.task.patientreg.service.PatientService;







public class PatientServiceImpl implements PatientService{
	
	PatientDao patientDao = new Patientdaoimpl();

	@Override
	public Patientdto getPatientByPatientId(String patientId) {
		// TODO Auto-generated method stub
		Patientdto patientdto = getBooking(patientId);
		return patientdto;
	}

	private Patientdto getBooking(String patientId) {
		// TODO Auto-generated method stub
		Patientdto patientdto;
		try {
			patientDao.openConnection();
			
			patientdto= patientDao.getPatientById(patientId);
		}
		finally {
			patientDao.closeConnection();
		}
		
		return patientdto;
	}
	

	

}
