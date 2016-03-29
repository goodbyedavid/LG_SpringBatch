package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Zipcodes;
import com.rovicorp.utils.RoviStringUtils;

public class ZipcodesProcessor implements ItemProcessor<Zipcodes, Zipcodes> {
	
	private static final Logger logger = LoggerFactory.getLogger(ZipcodesProcessor.class);

	@Override
	public Zipcodes process(Zipcodes zipcodes) throws Exception {
		
		logger.trace("Processing zipcodes HeadendID: [{}]", zipcodes.getHeadendID());

		zipcodes.setCityName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(zipcodes.getCityName(), 0, 50))));
		zipcodes.setStateName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(zipcodes.getStateName())));
		
		return zipcodes;
	}
}
