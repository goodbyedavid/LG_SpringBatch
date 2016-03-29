package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Mso;

public class MsoRowMapper implements RowMapper<Mso> {

	@Override
	public Mso mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Mso mso = new Mso();
		
		mso.setMsoID(rs.getString("MSO ID"));
		mso.setMsoName(rs.getString("MSO Name"));
		
		return mso;
	}
}
