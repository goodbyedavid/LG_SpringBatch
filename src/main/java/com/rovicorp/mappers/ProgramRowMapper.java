package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Program;

public class ProgramRowMapper implements RowMapper<Program> {

	@Override
	public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Program program = new Program();
		
		program.setShowType(rs.getString("Show Type"));
		program.setProgramID(rs.getString("Program ID"));
		program.setLongTitle(rs.getString("Long Title"));
		program.setSeriesParentProgramID(rs.getString("seriesParentProgramID"));
		program.setProgramTypeID(rs.getString("programTypeID"));
		program.setMediumTitle(rs.getString("Medium Title"));
		program.setShortTitle(rs.getString("Short Title"));
		program.setGridTitle(rs.getString("Grid Title"));
		program.setGrid2Title(rs.getString("Grid2 Title"));
		program.setCategory(rs.getString("Category"));
		program.setSubtitle(rs.getString("Subtitle"));
		program.setEpisodeTitle(rs.getString("Episode Title"));
		program.setEpisodeNumber(rs.getString("Episode Number"));
		program.setRuntime(rs.getString("Runtime"));
		program.setReleaseYear(rs.getString("Release Year"));
		program.setProgramLanguage(rs.getString("Program language"));
		program.setSyndicated(rs.getString("Syndicated"));
		program.setOriginalAirDate(rs.getString("Orginal Air Date"));
		program.setOriginalAirDateUS(rs.getString("Orginal Air Date US"));
		program.setEventDate(rs.getString("Event Date"));
		program.setHdtvLevel(rs.getString("HDTV Level"));
		program.setAudioLevel(rs.getString("Audio Level"));
		program.setMovieType(rs.getString("Movie Type"));
		program.setStarRating(rs.getString("Star Rating"));
		program.setLongDescription(rs.getString("Long Description"));
		program.setCategoryId(rs.getString("category id"));
		program.setChronoLong(rs.getString("Chrono Long"));
		program.setChronoLongCuttingPositionlist(rs.getString("Chrono Long Cutting Position"));
		program.setPromo(rs.getString("promo"));
		program.setPromoCuttingPositionlist(rs.getString("promo Cutting Position"));
		program.setNoCast(rs.getString("No Cast"));
		program.setNoCastCuttingPositionlist(rs.getString("No Cast Cutting Position"));
		program.setChronoShort(rs.getString("Chrono Short"));
		program.setChronoShortCuttingPositionlist(rs.getString("Chrono Short Cutting Position"));
		program.setGridCopy(rs.getString("Grid Copy"));
	    program.setGridCopyCuttingPositionlist(rs.getString("Grid Copy Cutting Position"));

		return program;
	}
}
