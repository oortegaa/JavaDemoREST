/**
 * 
 */
package com.wizeline.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Gelocation data of an IP
 * @author oortegaa
 *
 */
@ApiModel(value="GeoIPDto", description="Provides gelocation data of an IP")
public class GeoIPDto {

	@ApiModelProperty(value="your local ip")
	private String ip;
	
	@ApiModelProperty(value="Country code")
	private String country_code;
	
	@ApiModelProperty(value="Country name")
	private String country_name;
	
	@ApiModelProperty(value="Region code")
	private String region_code;
	
	@ApiModelProperty(value="Region name")
	private String region_name;
	
	@ApiModelProperty(value="City")
	private String city;
	
	@ApiModelProperty(value="Zip code")
	private String zip_code;
	
	@ApiModelProperty(value="Time zone")
	private String time_zone;
	
	@ApiModelProperty(value="latitude")
	private String latitude;
	
	@ApiModelProperty(value="longitude")
	private String longitude;
	
	@ApiModelProperty(value="Metro Code")
	private int metro_code;

	public GeoIPDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}

	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	/**
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}

	/**
	 * @param country_name the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	/**
	 * @return the region_code
	 */
	public String getRegion_code() {
		return region_code;
	}

	/**
	 * @param region_code the region_code to set
	 */
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	/**
	 * @return the region_name
	 */
	public String getRegion_name() {
		return region_name;
	}

	/**
	 * @param region_name the region_name to set
	 */
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip_code
	 */
	public String getZip_code() {
		return zip_code;
	}

	/**
	 * @param zip_code the zip_code to set
	 */
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * @return the time_zone
	 */
	public String getTime_zone() {
		return time_zone;
	}

	/**
	 * @param time_zone the time_zone to set
	 */
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the metro_code
	 */
	public int getMetro_code() {
		return metro_code;
	}

	/**
	 * @param metro_code the metro_code to set
	 */
	public void setMetro_code(int metro_code) {
		this.metro_code = metro_code;
	}

	
}
