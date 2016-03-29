package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.ProgramCredits;

public class ProgramCreditsRowMapper implements RowMapper<ProgramCredits> {

	@Override
	public ProgramCredits mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProgramCredits programCredits = new ProgramCredits();
		
		programCredits.setProgramID(rs.getString("Program ID"));
		programCredits.setCreditID(rs.getString("Credit ID"));
		programCredits.setCreditType(rs.getString("Credit_Type"));
		programCredits.setFirstName(rs.getString("First Name"));
		programCredits.setLastName(rs.getString("Last Name"));
		programCredits.setFullCreditName(rs.getString("Full Credit Name"));
		programCredits.setPartName(rs.getString("Part Name"));
		programCredits.setSequenceNumber(rs.getString("Sequence  Number"));
		
		return programCredits;
	}
}
