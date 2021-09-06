package com.wizeline.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Error Acknowledge
 * @author oortegaa.
 *
 */
@ApiModel(value="AckDto", description="Error descriptions")
public class AckDto {

	@ApiModelProperty(value="Error code")
	private Integer code;
	
	@ApiModelProperty(value="Error description")
	private String description;
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	
	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final Integer code) {
		this.code = code;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	
}
