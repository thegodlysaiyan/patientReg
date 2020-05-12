package com.task.patientreg.dao.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.patienreg.dao.PatientDao;
import com.task.patienreg.dto.Patientdto;


@RunWith(MockitoJUnitRunner.class)
public class Patientdaoimpltest {
	
	@Mock
	PatientDao impl;
	
	@Test
	public void getPatientByIdTest() {
		
		Patientdto patient= new Patientdto();
		patient.setHeight("6ft 3inch");
		Mockito.when(impl.getPatientById("irz9wYHR")).thenReturn(patient);
		
		String actual= impl.getPatientById("irz9wYHR").getHeight();
		assertEquals("6ft 3inch", actual);
		
		
	}

}
