package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.SourceGenre;
import com.rovicorp.utils.RoviStringUtils;

public class SourceGenreProcessor implements ItemProcessor<SourceGenre, SourceGenre> {
	
	private static final Logger logger = LoggerFactory.getLogger(SourceGenreProcessor.class);
	
	@Override
	public SourceGenre process(SourceGenre sourceGenre) throws Exception {
		
		logger.trace("Processing SourceGenre SourceID: [{}]", sourceGenre.getSourceID());

		sourceGenre.setGenre(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(sourceGenre.getGenre())));
		
		return sourceGenre;
	}
}
