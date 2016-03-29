package com.rovicorp.processors;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.ProgramTvRatings;
import com.rovicorp.service.ProgramRatingTVAdvisoryService;
import com.rovicorp.utils.RoviStringUtils;

public class ProgramTVRatingProcessor implements ItemProcessor<ProgramTvRatings, ProgramTvRatings> {
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramTvRatings.class);

	@Override
	public ProgramTvRatings process(ProgramTvRatings programTvRatings) throws Exception {
		
		logger.trace("Processing ProgramTvRatings ProgramID: [{}]", programTvRatings.getProgramID());

		programTvRatings.setTvRatingType(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(programTvRatings.getTvRatingType(), 0, 5))));
				
		//TV Advisory
		HashMap<String, String> ratings = ProgramRatingTVAdvisoryService.getRatingByRatingId(programTvRatings.getName());
        if(ratings != null) {
               programTvRatings.setTvRating(StringUtils.trim(StringUtils.substring(StringUtils.replace(ratings.get("TVRating"), "-", ""), 0, 6)));
               programTvRatings.setTvAdvisory(StringUtils.trim(ratings.get("TVAdvisory")));
        } else {
               programTvRatings.setTvRating("");
               programTvRatings.setTvAdvisory("");
        }
			
        return programTvRatings;
	}
}



