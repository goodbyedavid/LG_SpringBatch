package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.ProgramMovieRatings;

public class ProgramMovieRatingsRowMapper implements RowMapper<ProgramMovieRatings> {

	@Override
	public ProgramMovieRatings mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProgramMovieRatings programMovieRatings = new ProgramMovieRatings();
		
		programMovieRatings.setProgramID(rs.getString("Program ID"));
		programMovieRatings.setMovieRatingType(rs.getString("Movie Rating Type"));
		//programMovieRatings.setMovieRating(rs.getString("Movie Rating"));
		programMovieRatings.setMovieRatingReason(rs.getString("Movie Rating Reasons"));
		programMovieRatings.setNAME(rs.getString("NAME"));
		
		return programMovieRatings;
	}
}
