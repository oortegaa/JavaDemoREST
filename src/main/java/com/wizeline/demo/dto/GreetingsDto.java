/**
 * 
 */
package com.wizeline.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Greeting message
 * @author oortegaa
 * 
 */
@ApiModel(value="GreetingsDto", description="Greeting message")
public class GreetingsDto {

	@ApiModelProperty(value="Message to print")
	private String message;

	public GreetingsDto(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	

}
