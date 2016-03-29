package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Zipcodes;

public class ZipcodesRowMapper implements RowMapper<Zipcodes> {

	@Override
	public Zipcodes mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Zipcodes zipcodes = new Zipcodes();
		
		zipcodes.setHeadendID(rs.getString("Headend ID"));
		zipcodes.setZipCode(rs.getString("Zip Code"));
		zipcodes.setCityName(rs.getString("City Name"));
		zipcodes.setStateName(rs.getString("State Name"));
		
		return zipcodes;
	}
}
