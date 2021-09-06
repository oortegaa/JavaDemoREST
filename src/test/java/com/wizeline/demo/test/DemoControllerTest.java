package com.wizeline.demo.test;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizeline.demo.controller.DemoController;
import com.wizeline.demo.dto.GreetingsDto;
import com.wizeline.demo.services.GreetingsService;

/**
 * @author oortegaa
 *
 */
@WebMvcTest(DemoController.class)
public class DemoControllerTest {
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
	
	@MockBean
	private GreetingsService greetingsService;
	
	static String basicDigestHeaderValue;
	
	@BeforeAll
	public static void autentication() {
		basicDigestHeaderValue = "Basic " + new String(Base64.encodeBase64(("usrWizeline:wizeline").getBytes()));
	}
	
	
	@Test
	public void greeting_Test() throws Exception {
		
		//String basicDigestHeaderValue = "Basic " + new String(Base64.encodeBase64(("usrWizeline:wizeline").getBytes()));
		
		
		String message = "Hello Alex from Wizeline!";
		GreetingsDto greetings = new GreetingsDto(message);
		
		Mockito.when(greetingsService.getGreeting(message)).thenReturn(greetings);
		mockMvc.perform(MockMvcRequestBuilders
		            .get("/greetings")
		            .header("Authorization", basicDigestHeaderValue)
		            .param("name", "Alex")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk())
		            .andExpect(jsonPath("$.message", is(message)));
	}
	
	@Test
	public void GeoIp_Ok_Test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/geoip")
	            .header("Authorization", basicDigestHeaderValue))
	            .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void GeoIp_NoOk_Test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/geoip")
	            .param("ip", "172.test.error")
	            .header("Authorization", basicDigestHeaderValue))
	            .andExpect(status().isBadRequest());
	}
	
	@Test
	public void GeoIp_MX_Test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/geoip")
	            .param("ip", "177.225.138.104")
	            .header("Authorization", basicDigestHeaderValue)
	            .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.country_code", is("MX")));
	}

}
