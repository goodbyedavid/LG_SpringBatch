package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Schedule;

public class ScheduleRowMapper implements RowMapper<Schedule> {

	@Override
	public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Schedule schedule = new Schedule();
		
		schedule.setSourceID(rs.getString("Source ID"));
		schedule.setStartDate(rs.getString("Start Date"));
		schedule.setStartTime(rs.getString("Start Time"));
		schedule.setIsTimeApproximate(rs.getString("Is Time Approximate"));
		schedule.setDuration(rs.getString("Duration"));
		schedule.setProgramID(rs.getString("Program ID"));
		schedule.setProgramShowingType(rs.getString("Program Showing Type"));
		schedule.setCaptionType(rs.getString("Caption Type"));
		schedule.setAudioLevelName(rs.getString("Audio Level Name"));
		schedule.setSap(rs.getString("SAP"));
		schedule.setProgramAiringType(rs.getString("Program Airing Type"));
		schedule.setSubtitled(rs.getString("Subtitled"));
		schedule.setJoinedInProgress(rs.getString("Joined In Progress"));
		schedule.setSubjectToBlackout(rs.getString("Subject to Blackout"));
		schedule.setAspectRatio(rs.getString("Aspect Ratio"));
		schedule.setDsv(rs.getString("DSV"));
		schedule.setPartNumber(rs.getString("Part Number"));
		schedule.setPartTotal(rs.getString("Part Total"));
		schedule.setHdtvLevelName(rs.getString("HDTV Level Name"));
		schedule.setSyndicated(rs.getString("Syndicated"));
		schedule.setProgramTypeID(rs.getString("Program Type ID"));
		schedule.setSeriesParentProgramID(rs.getString("Series Parent Program ID"));
		schedule.setRatingName(rs.getString("Rating Name"));
		schedule.setErrorStatusID(rs.getString("Error Status ID"));
		schedule.setColorType(rs.getString("Color Type"));
		
		return schedule;
	}
}
