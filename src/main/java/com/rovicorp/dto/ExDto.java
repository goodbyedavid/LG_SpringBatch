package com.rovicorp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akupinski
 * ExDTP is for For Demonstration Purposes Only!!!!
 * Don't use..
 */
 
public class ExDto {
	private static final Logger logger = LoggerFactory.getLogger(ExDto.class);
	private String id;
	private String name;
	
	public void ExDTO(){
		logger.info("ExDto wired: DEMO CODE!!!! UNWIRE ME PRIOR TO REAL DEVELOPMENT ");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
