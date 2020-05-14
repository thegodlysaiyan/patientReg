package dao.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.patienreg.dao.entity.PatientEntity;
import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.model.response.RegResponse;


@RunWith(MockitoJUnitRunner.class)
public class Patientdaoimpltest {
	
	@Mock
	PatientDao impl;
	
	@Test
	public void getPatientByIdHappyFlowTest() {
		
		Patientdto patient= new Patientdto();
		patient.setHeight("6ft 3inch");
		Mockito.when(impl.getPatientById("5")).thenReturn(patient);
		
		String actual= impl.getPatientById("5").getHeight();
		assertEquals("6ft 3inch", actual);		
	}
	
	@Test
	public void getPatientByIdNegativeFlowTest() {
		
		Patientdto patient=new Patientdto();
		
		Mockito.when(impl.getPatientById("15")).thenReturn(patient);
		
		String actual= impl.getPatientById("15").getHeight();
		assertEquals(null, actual);		
	}
	
	@Test
	public void savePatientHappyFlowTest() {
		
		Patientdto patient=new Patientdto();
		PatientEntity patientEntity=new PatientEntity();
		Patientdto savedPatient = new Patientdto();
		BeanUtils.copyProperties(patient, patientEntity);
		BeanUtils.copyProperties(patientEntity, savedPatient);
		
		Mockito.when(impl.savePatient(patient)).thenReturn(savedPatient);
		
		Patientdto actual= impl.savePatient(patient);
		assertEquals(savedPatient, actual);		
	}
	
	
	

}
