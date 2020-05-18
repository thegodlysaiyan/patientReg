package dao.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dao.entity.PatientEntity;
import com.task.patientreg.dao.impl.Patientdaoimpl;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.model.response.RegResponse;


//@RunWith(MockitoJUnitRunner.class)
public class Patientdaoimpltest {
	
	private static PatientDao impl = new Patientdaoimpl();
	
//	@Mock
//	PatientDao impl;
	
	@BeforeClass
	public static void runBefore() {
		impl.openConnection();
	}
	
	@AfterClass
	public static void runAfter() {
		impl.closeConnection();
	}
	
	
	@Test
	public void getPatientByIdHappyFlowTest() {
		
		Patientdto patient=impl.getPatientById("3");
		assertEquals("67", patient.getHeart_rate());
	
	}
	
	
	
	@Test
	public void getPatientByIdNegativeFlowTest() {
		
		Patientdto patient=impl.getPatientById("40");
		assertEquals(null, patient);		
	}
	
	@Test
	public void savePatientHappyFlowTest() {
		
		Patientdto patient = new Patientdto();	
		patient.setHeight("6ft 2inch");
		patient.setWeight("80Kg");
		patient.setTemperature("60C");
		patient.setBlood_pressure("180/140");
		patient.setBmi("35");
		patient.setHeart_rate("76");
		
		Patientdto actual = impl.savePatient(patient);
		
		assertEquals(patient.getBmi(), actual.getBmi());
	}

}
