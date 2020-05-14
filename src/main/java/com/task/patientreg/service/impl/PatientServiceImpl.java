package com.task.patientreg.service.impl;


import java.util.List;
import java.util.Map;

import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dao.impl.Patientdaoimpl;
import com.task.patientreg.database.DatabaseClass;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.exception.InvalidRequestException;
import com.task.patientreg.model.request.RegistrationRequest;
import com.task.patientreg.request.utils.PatientUtils;
import com.task.patientreg.service.PatientService;







public class PatientServiceImpl implements PatientService{
	
	PatientUtils utils= new PatientUtils();
	PatientDao patientDao = new Patientdaoimpl();

	@Override
	public Patientdto getPatientByPatientId(String patientId) {
		// TODO Auto-generated method stub
		Patientdto patientdto = getPatient(patientId);
		return patientdto;
	}

	private Patientdto getPatient(String patientId) {
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

	@Override
	public Patientdto createPatient(Patientdto patientdto) throws InvalidRequestException{
		// TODO Auto-generated method stub
		
		Patientdto patdto = new Patientdto();
		utils.validatePatientRequest(patientdto);
		
		patdto = savePatient(patientdto);
		return patdto;
	}

	private Patientdto savePatient(Patientdto patientdto) {
		// TODO Auto-generated method stub
		Patientdto patdto;
		try {
			patientDao.openConnection();
			
			patdto= patientDao.savePatient(patientdto);
		}
		finally {
			patientDao.closeConnection();
		}
		
		return patdto;
		
	}
	

	

}
