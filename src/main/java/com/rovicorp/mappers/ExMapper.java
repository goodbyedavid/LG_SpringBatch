package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.ExDto;
/**
 * 
 * @author akupinski
 * This is an example of a row mapper. 
 * is for For Demonstration Purposes Only!!!!
 * Don't use..
 */

public class ExMapper implements RowMapper<ExDto>{
	private static final Logger logger = LoggerFactory.getLogger(ExMapper.class);
	
	public ExMapper(){
		logger.info("ExMapper wired: DEMO CODE!!!! UNWIRE ME PRIOR TO REAL DEVELOPMENT ");
	}
	
	@Override
	public ExDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		logger.debug("ExMapper is for For Demonstration Purposes Only!!!!");
		ExDto exDto=new ExDto();
		exDto.setId(rs.getString("id"));
		exDto.setName(rs.getString("name"));
		return exDto;
	}

}
