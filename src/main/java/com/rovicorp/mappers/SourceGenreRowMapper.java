package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.SourceGenre;

public class SourceGenreRowMapper implements RowMapper<SourceGenre> {

	@Override
	public SourceGenre mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SourceGenre sourceGenre = new SourceGenre();
		
		sourceGenre.setSourceID(rs.getString("Source ID"));
		sourceGenre.setGenre(rs.getString("Genre"));
		
		return sourceGenre;
	}
}
