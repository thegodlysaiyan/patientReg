package resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.model.request.RegistrationRequest;
import com.task.patientreg.model.response.RegResponse;
import com.task.patientreg.resources.PatientRegistration;
import com.task.patientreg.service.PatientService;

@RunWith(MockitoJUnitRunner.class)
public class ResourceTest {
	
	@Mock
	PatientService service;
	
	@InjectMocks
	PatientRegistration resource = new PatientRegistration();
	
	@Test
	public void getPatientByIdTest() {
		
		Patientdto patient = new Patientdto();
		patient.setBmi("30");
		
		Mockito.when(service.getPatientByPatientId("1")).thenReturn(patient);
		
		RegResponse response = resource.getPatientById("1");
		
		assertEquals("30", response.getBmi());		
	}
	
	@Test
	public void addPatientInfoTest() {
		
		RegistrationRequest request = new RegistrationRequest();
		request.setHeight("6ft 2inch");
		request.setWeight("80Kg");
		request.setTemperature("60C");
		request.setBlood_pressure("180/140");
		request.setBmi("35");
		request.setHeart_rate("76");
		
//		Patientdto patientdto = new Patientdto();
//		BeanUtils.copyProperties(request, patientdto);
		
		Patientdto savedPatient = new Patientdto();
		savedPatient.setId(40);
		savedPatient.setHeight("6ft 2inch");
		savedPatient.setWeight("80Kg");
		savedPatient.setTemperature("60C");
		savedPatient.setBlood_pressure("180/140");
		savedPatient.setBmi("35");
		savedPatient.setHeart_rate("76");
		
		Mockito.when(service.createPatient(Mockito.any(Patientdto.class))).thenReturn(savedPatient);
		
		RegResponse response = resource.addPatientInfo(request);
		
		assertEquals("35", response.getBmi());
		
	}

}
