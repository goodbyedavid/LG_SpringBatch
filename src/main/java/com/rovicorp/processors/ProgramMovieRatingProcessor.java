package com.rovicorp.processors;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.ProgramMovieRatings;
import com.rovicorp.service.ProgramRatingTVAdvisoryService;
import com.rovicorp.utils.RoviStringUtils;


public class ProgramMovieRatingProcessor implements ItemProcessor<ProgramMovieRatings, ProgramMovieRatings> {
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramMovieRatings.class);
	
	@Override
	public ProgramMovieRatings process(ProgramMovieRatings programMovieRatings) throws Exception {
		
		logger.trace("Processing ProgramMovieRatings ProgramID: [{}]", programMovieRatings.getProgramID());
		
		programMovieRatings.setMovieRatingType(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(programMovieRatings.getMovieRatingType(), 0, 5))));
		programMovieRatings.setMovieRatingReason(RoviStringUtils.replaceAllSpecialCharacters(programMovieRatings.getMovieRatingReason()));
		
		HashMap<String, String> ratings = ProgramRatingTVAdvisoryService.getRatingByRatingId(programMovieRatings.getNAME());
		if(ratings != null) {
			programMovieRatings.setMovieRating(StringUtils.trim(StringUtils.substring(StringUtils.replace(ratings.get("TVRating"), "-", ""), 0, 6)));
		} else {
			programMovieRatings.setMovieRating("");
		}
		
		return programMovieRatings;
	}
}
