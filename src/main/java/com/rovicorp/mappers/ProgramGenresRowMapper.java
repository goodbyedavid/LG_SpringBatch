package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.ProgramGenres;

public class ProgramGenresRowMapper implements RowMapper<ProgramGenres> {

	@Override
	public ProgramGenres mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProgramGenres programGenres = new ProgramGenres();
		
		programGenres.setProgramID(rs.getString("Program ID"));
		programGenres.setGenre2(rs.getString("Genre2"));
		
		return programGenres;
	}
}
