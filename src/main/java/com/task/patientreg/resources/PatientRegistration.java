package com.task.patientreg.resources;

import com.task.patientreg.service.impl.PatientService;
import com.task.patienreg.dao.PatientDao;
import com.task.patienreg.dao.impl.Patientdaoimpl;
import com.task.patienreg.dto.Patientdto;
import com.task.patientreg.model.request.RegistrationRequest;
import com.task.patientreg.model.response.RegResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.springframework.beans.BeanUtils;

import jakarta.ws.rs.PathParam;

@Path("/patient")
public class PatientRegistration {
	
	PatientService patientService = new PatientService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RegistrationRequest> getAllPatientInfo() {
		return patientService.getAllPatients();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RegistrationRequest getSinglePatientInfo(@PathParam("id") int id) {
		return patientService.getPatient(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RegResponse addPatientInfo(RegistrationRequest request) {
		
		RegResponse response = new RegResponse();
		//prepare bookingdto
				Patientdto patientdto = new Patientdto();
				BeanUtils.copyProperties(request, patientdto);
				
				//create booking
				PatientDao patientdao= new Patientdaoimpl();
				Patientdto createdpatientdto = patientdao.savePatient(patientdto);
				
				//prepare response
				BeanUtils.copyProperties(createdpatientdto, response);
		
		
		return response;
		
		//return patientService.addPatient(request);
	}


}
