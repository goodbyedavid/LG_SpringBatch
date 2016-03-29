package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.ProgramGenres;
import com.rovicorp.utils.RoviStringUtils;

public class ProgramGenreProcessor implements ItemProcessor<ProgramGenres, ProgramGenres> {
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramGenres.class);
	
	@Override
	public ProgramGenres process(ProgramGenres programGenres) throws Exception {
		
		logger.trace("Processing ProgramGenre ProgramID: [{}]", programGenres.getProgramID());

		programGenres.setGenre2(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(programGenres.getGenre2())));
		
		return programGenres;
	}
}
