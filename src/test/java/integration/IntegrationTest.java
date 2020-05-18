package integration;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.patientreg.model.response.RegResponse;

public class IntegrationTest {
	
	@Test
	public void testforGET() throws IOException {
		URL url = new URL("http://localhost:8081/patientreg/webapi/patient/3" );
		String response= new String();
		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
		//urlConnect.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJtZWRib29raW5nLmFwaSIsImlhdCI6MTU4OTI3MjM5Miwic3ViIjoiYXBwdXNlciIsInJvbGVzIjoidXNlciIsImlzcyI6Im1lZGJvb2tpbmciLCJleHAiOjE1ODkyNzU5OTJ9.JUWvJnuzzEHt2-Xqj2SHwHKOYNz_pdtBthl3uoBUrgA");
		urlConnect.setRequestProperty("Accept", "application/json");
		
		InputStream is = urlConnect.getInputStream();
		
		int i = 0;
		while((i =  is.read()) != -1 ) {
			response=response+(char)i;
			System.out.print((char)i);
		}
		
		try {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	        RegResponse jsonMap = mapper.readValue(response, RegResponse.class);

	        System.out.println(jsonMap.getId());
	       assertEquals(3, jsonMap.getId());
	    } finally {
	        is.close();
	    }
		
	}
	
	@Test
	public void  testforPOST() throws IOException {
		URL url = new URL("http://localhost:8081/patientreg/webapi/patient" );
		String response= new String();
		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
		urlConnect.setRequestMethod("POST");
		//urlConnect.setRequestProperty("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJtZWRib29raW5nLmFwaSIsImlhdCI6MTU4OTI3MjM5Miwic3ViIjoiYXBwdXNlciIsInJvbGVzIjoidXNlciIsImlzcyI6Im1lZGJvb2tpbmciLCJleHAiOjE1ODkyNzU5OTJ9.JUWvJnuzzEHt2-Xqj2SHwHKOYNz_pdtBthl3uoBUrgA");
		urlConnect.setRequestProperty("Content-Type", "application/json");
		urlConnect.setRequestProperty("Accept", "application/json");
		urlConnect.setDoOutput(true);
		
		String jsonInputString = "{\r\n" + 
				"	\r\n" + 
				"	\"height\":\"5ft 9inch\",\r\n" + 
				"	\"weight\":\"65Kg\",\r\n" + 
				"	\"temperature\":\"80C\",\r\n" + 
				"	\"blood_pressure\":\"175/125\",\r\n" + 
				"	\"bmi\":\"44.6\",\r\n" + 
				"	\"heart_rate\":\"75\"\r\n" + 
				"	\r\n" + 
				"}\r\n";
		
		try(OutputStream os = urlConnect.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);           
		}
		
		InputStream is = urlConnect.getInputStream();
		
		int i = 0;
		while((i =  is.read()) != -1 ) {
			response=response+(char)i;
			System.out.print((char)i);
		}
		
		try {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	        RegResponse jsonMap = mapper.readValue(response, RegResponse.class);

	        System.out.println(jsonMap.getId());
	       assertEquals("65Kg", jsonMap.getWeight());
	    } finally {
	        is.close();
	    }
		
	}

}
