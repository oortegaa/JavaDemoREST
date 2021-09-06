/**
 * 
 */
package com.wizeline.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wizeline.demo.business.Validation;
import com.wizeline.demo.dto.AckDto;
import com.wizeline.demo.dto.GeoIPDto;
import com.wizeline.demo.dto.GreetingsDto;
import com.wizeline.demo.services.GreetingsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Receive HTTP requests for Greetings operations
 * @author oortegaa
 */
@Api(tags= {"Demo Service"}, value = "some operations")
@RestController
public class DemoController {
	
	@Autowired
	GreetingsService greetingsService;
	
	/** Elemento para registro en bitacora. */
	private static final Logger LOGGER 
	= LogManager.getLogger(DemoController.class);
	
	private static String message = "Hello %s from Wizeline!";

	/**
	 * 
	 * @param userName Receive value of parameter 'Name'
	 * from the url if it is provided
	 * @return Greetins Class in json
	 */
	@ApiOperation(value = "Hello operation", response = GreetingsDto.class)
	@GetMapping("/greetings")
	public ResponseEntity<GreetingsDto> greetings (
			@ApiParam(value = "user name to say Hello", required = false, 
			defaultValue = "My Friend" )
			@RequestParam(value = "name", defaultValue = "My Friend") 
				String userName) {
		LOGGER.info("greetings - start");
		GreetingsDto aa = greetingsService.getGreeting(String.format(message, userName));
				
		return new ResponseEntity<>(aa, HttpStatus.OK);
	}
	

	/**
	 * Get geolocation for specific IP
	 * @param ip
	 * @return
	 */
	@ApiOperation(value = "provides an IP geolocation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "", response = GeoIPDto.class),
			@ApiResponse(code = 402, message = "Bad request", response = AckDto.class)
		}
	)
	@GetMapping("/geoip")
	public ResponseEntity<Object> GeoIp(@ApiParam(value = "IP", 
		required = false, defaultValue = "")
			@RequestParam(value = "ip", defaultValue = "") 
				String ip) {
		
		LOGGER.info("geoip - start");
		
		RestTemplate restTemplate = new RestTemplate();
		Validation validation = new Validation();
		ResponseEntity<Object> responseEntity = null;
		GeoIPDto result;
		
		String uri = "https://freegeoip.app/json/";
		//RestTemplate restTemplate = new RestTemplate();
		
		if (ip.isEmpty()) {
		    result = restTemplate.getForObject(uri, GeoIPDto.class);
		    responseEntity = new ResponseEntity<Object>(result, 
		    		HttpStatus.OK);
		}				
		else if (validation.isValidIPAddress(ip)) {
			uri = "https://freegeoip.app/json/" + ip;
			result = restTemplate.getForObject(uri, GeoIPDto.class);
			responseEntity = new ResponseEntity<Object>(result, 
		    		HttpStatus.OK);
		}
		else {
			LOGGER.error("Invalid IP: " + ip);
			responseEntity = ackError(400, "Invalid IP", 
					HttpStatus.BAD_REQUEST);
		}
	    
		return responseEntity;
	}
	
	
	/**
	 * Fill ack response
	 * @param code Response code
	 * @param description Response description
	 * @param status Http status
	 * @return ResponseEntity
	 */
	private ResponseEntity<Object> ackError(int code, String description,
			HttpStatus status) {
		
		AckDto ack = new AckDto();

		ack.setCode(code);		
		ack.setDescription(description);

		ResponseEntity<Object> responseEntity = new 
		        ResponseEntity<Object>(ack, status);
		
		return responseEntity;
	}
		
}
