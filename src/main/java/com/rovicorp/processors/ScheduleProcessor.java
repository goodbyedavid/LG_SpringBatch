package com.rovicorp.processors;


import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Schedule;
import com.rovicorp.service.ProgramColorTypeService;
import com.rovicorp.service.ProgramRatingTVAdvisoryService;
import com.rovicorp.utils.RoviStringUtils;


public class ScheduleProcessor implements ItemProcessor<Schedule, Schedule> {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleProcessor.class);
	
	@Override
	public Schedule process(Schedule schedule) throws Exception {
		
		logger.trace("Processing Schedule ProgramId, SourceId: [{}, {}]", schedule.getProgramID(), schedule.getSourceID());
	
		if(schedule.getIsTimeApproximate().equals("1"))
			schedule.setIsTimeApproximate("Y");
		else
			schedule.setIsTimeApproximate("N");
		
		if(schedule.getProgramTypeID() != null && (schedule.getProgramTypeID().equals("2") || schedule.getProgramTypeID().equals("3")))
			if(schedule.getSeriesParentProgramID() == null)
				schedule.setSeriesID(schedule.getProgramID());
			else
				schedule.setSeriesID(StringUtils.stripToEmpty(schedule.getSeriesParentProgramID()));
		else
			schedule.setSeriesID("");
				
		HashMap<String, String> ratings = ProgramRatingTVAdvisoryService.getRatingByRatingId(schedule.getRatingName());
		if(ratings != null) {
			schedule.setTvRating(StringUtils.trim(StringUtils.substring(StringUtils.replace(ratings.get("TVRating"), "-", ""), 0, 6)));
			schedule.setTvAdvisory(StringUtils.trim(ratings.get("TVAdvisory")));
		} else {
			schedule.setTvRating("");
			schedule.setTvAdvisory("");
		}
		
		schedule.setColorType(StringUtils.stripToEmpty(ProgramColorTypeService.getProgramColorTypeById(schedule.getColorType())));
		
		if(schedule.getErrorStatusID() != null)
			schedule.setProgramID("813735");
		
		if(schedule.getProgramShowingType().equalsIgnoreCase("none"))
			schedule.setProgramShowingType("");
		
		if(schedule.getAudioLevelName().equalsIgnoreCase("none"))
			schedule.setAudioLevelName("");
		
		if(schedule.getProgramAiringType().equalsIgnoreCase("none"))
			schedule.setProgramAiringType("");
		
		if(schedule.getJoinedInProgress().equals("1"))
			schedule.setJoinedInProgress("Y");
		else
			schedule.setJoinedInProgress("N");
		
		if(schedule.getSubjectToBlackout().equals("1"))
			schedule.setSubjectToBlackout("Y");
		else
			schedule.setSubjectToBlackout("N");
		
		if(schedule.getHdtvLevelName().equalsIgnoreCase("none"))
			schedule.setHdtvLevelName("");
		
		if(schedule.getCaptionType().equals(""))
			schedule.setCaptionType("None");	
		
		schedule.setSyndicated(StringUtils.trim(schedule.getSyndicated()));
		
		if(schedule.getSyndicated() != null && !schedule.getSyndicated().equalsIgnoreCase("Y"))
			schedule.setSyndicated("N");
		
		schedule.setCaptionType(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(schedule.getCaptionType())));
		
		schedule.setStartDate(StringUtils.replace(schedule.getStartDate(), "-", ""));
		
		return schedule;
	}
}
