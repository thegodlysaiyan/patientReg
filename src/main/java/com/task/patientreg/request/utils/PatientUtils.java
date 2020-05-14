package com.task.patientreg.request.utils;

import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.exception.InvalidRequestException;
import com.task.patientreg.model.response.ErrorMessages;



public class PatientUtils {

	public void validatePatientRequest(Patientdto patientdto) throws InvalidRequestException{
		// TODO Auto-generated method stub
		if(patientdto.getHeight()==null || patientdto.getHeight().isEmpty() ||
				patientdto.getWeight()==null || patientdto.getWeight().isEmpty() ||
				patientdto.getTemperature()==null || patientdto.getTemperature().isEmpty() ||
				patientdto.getBlood_pressure()==null || patientdto.getBlood_pressure().isEmpty() ||
				patientdto.getBmi()==null || patientdto.getBmi().isEmpty() ||
				patientdto.getHeart_rate()==null || patientdto.getHeart_rate().isEmpty() ) {
			throw new InvalidRequestException(ErrorMessages.INVALID_FIELD.getErrormessage());
		}
	}

}
