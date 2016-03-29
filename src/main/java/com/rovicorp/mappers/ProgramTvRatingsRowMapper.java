package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.ProgramTvRatings;

public class ProgramTvRatingsRowMapper implements RowMapper<ProgramTvRatings>{

	@Override
	public ProgramTvRatings mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProgramTvRatings programTvRatings = new ProgramTvRatings();
		
		programTvRatings.setProgramID(rs.getString("Program ID"));
		programTvRatings.setTvRatingType(rs.getString("TV Rating Type"));
		programTvRatings.setName(rs.getString("NAME"));
		
		return programTvRatings;
	}
}
