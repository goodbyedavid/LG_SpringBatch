package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Channellineup;
import com.rovicorp.utils.RoviStringUtils;

public class ChannellineupProcessor implements ItemProcessor<Channellineup, Channellineup> {
	
	private static final Logger logger = LoggerFactory.getLogger(ChannellineupProcessor.class);

	@Override
	public Channellineup process(Channellineup channellineup) throws Exception {
		
		logger.trace("Processing Channellineup headendID: [{}]", channellineup.getHeadendID());


		channellineup.setCallLetters(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(channellineup.getCallLetters())));
		channellineup.setEffectiveDate(StringUtils.substring(channellineup.getEffectiveDate(), 0, 16));
		channellineup.setExpirationDate(StringUtils.substring(channellineup.getExpirationDate(), 0, 16));
		channellineup.setChannelNumber(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(channellineup.getChannelNumber())));
		
		return channellineup;
	}
	
}
