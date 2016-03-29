package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.ProgramCredits;
import com.rovicorp.utils.RoviStringUtils;

public class ProgramCreditsProcessor implements ItemProcessor<ProgramCredits, ProgramCredits> {
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramCredits.class);
	
	@Override
	public ProgramCredits process(ProgramCredits programCredits) throws Exception {
		
		logger.trace("Processing ProgramCredits ProgramID: [{}]", programCredits.getProgramID());

		programCredits.setCreditType(RoviStringUtils.replaceAllSpecialCharacters(programCredits.getCreditType()));
		programCredits.setFirstName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.substring(programCredits.getFirstName(), 0, 60)));
		programCredits.setLastName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.substring(programCredits.getLastName(), 0, 60)));
		programCredits.setFullCreditName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.substring(programCredits.getFullCreditName(), 0, 120)));
		programCredits.setPartName(RoviStringUtils.replaceAllSpecialCharacters(programCredits.getPartName()));
		
		return programCredits;
	}
}
