package com.task.patientreg.resources;

import com.task.patientreg.service.PatientService;
import com.task.patientreg.service.impl.PatientServiceImpl;
import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dao.impl.Patientdaoimpl;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.model.request.RegistrationRequest;
import com.task.patientreg.model.response.RegResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import org.springframework.beans.BeanUtils;

import jakarta.ws.rs.PathParam;

@Path("/patient")
public class PatientRegistration {
	
	@GET
	@Path("/{patientId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public RegResponse getPatientById(@PathParam("patientId") String patientId) {
		RegResponse response= new RegResponse();
		
		
			PatientService patientService= new PatientServiceImpl();
			Patientdto patientdto = patientService.getPatientByPatientId(patientId);
		
			BeanUtils.copyProperties(patientdto, response);
		return response;
	}
	

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RegResponse addPatientInfo(RegistrationRequest request) {
		
		RegResponse response = new RegResponse();
		
				Patientdto patientdto = new Patientdto();
				BeanUtils.copyProperties(request, patientdto);				
				
				PatientService patientService= new PatientServiceImpl();
				Patientdto createdpatientdto = patientService.createPatient(patientdto);
							
				BeanUtils.copyProperties(createdpatientdto, response);
		
		
		return response;
		
		
	}


}
