package service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.exception.NoPatientFoundException;
import com.task.patientreg.exception.InvalidRequestException;
import com.task.patientreg.model.response.ErrorMessages;
import com.task.patientreg.service.impl.PatientServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceImplTest {
	
	@Mock
	PatientDao dao;
	
	@InjectMocks
	PatientServiceImpl impl = new PatientServiceImpl(dao);
	
	@Test
	public void getPatientByIdPositiveTest() {
		
		Patientdto patient = new Patientdto();
		patient.setBmi("30");
		Mockito.when(dao.getPatientById("1")).thenReturn(patient);
		
		Patientdto actual = impl.getPatientByPatientId("1");
		assertEquals(patient.getBmi(),actual.getBmi());
		
	}
	
	@Test(expected = NoPatientFoundException.class)
	public void getPatientByIdNegativeTest() {
		
		//Patientdto patient = new Patientdto();
		
		Mockito.when(dao.getPatientById("9")).thenThrow(new NoPatientFoundException("Error"));
		
		impl.getPatientByPatientId("9");	
	}
	
	@Test
	public void savePatientPositiveTest() {
		
		Patientdto patient = new Patientdto();
		patient.setId(1);
		patient.setHeight("6ft 2inch");
		patient.setWeight("80Kg");
		patient.setTemperature("60C");
		patient.setBlood_pressure("180/140");
		patient.setBmi("35");
		patient.setHeart_rate("76");
		
		
		Mockito.when(dao.savePatient(patient)).thenReturn(patient);
		
		Patientdto actual = impl.createPatient(patient);
		assertEquals(actual,patient);		
	}
	
	@Test(expected = InvalidRequestException.class)
	public void savePatientNegativeTest() {
		Patientdto patient = new Patientdto();
		patient.setId(1);
		patient.setHeight("");
		patient.setWeight("");
		patient.setTemperature("");
		patient.setBlood_pressure("180/140");
		patient.setBmi("");
		patient.setHeart_rate("");
		
		Mockito.when(dao.savePatient(patient)).thenThrow(new InvalidRequestException("Error"));
		
		impl.createPatient(patient);
		
	}
	

}
