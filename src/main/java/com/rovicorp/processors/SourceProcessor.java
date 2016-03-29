package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Source;
import com.rovicorp.utils.RoviStringUtils;
import com.rovicorp.utils.RoviTimeZoneUtil;

public class SourceProcessor implements ItemProcessor<Source, Source> {
	
	private static final Logger logger = LoggerFactory.getLogger(SourceProcessor.class);
	
	@Override
	public Source process(Source source) throws Exception {
		
		logger.trace("Processing Source SourceID: [{}]", source.getSourceID());

		source.setShortName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getShortName(), 0, 8))));
		source.setFullName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(source.getFullName())));
		source.setCallLetters(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getCallLetters(), 0, 20))));
		source.setOfficialCallSign(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getOfficialCallSign(), 0, 12))));
		source.setAffiliate1(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getAffiliate1(), 0, 30))));
		source.setAffiliate2(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getAffiliate2(), 0, 30))));
		source.setAffiliate3(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getAffiliate3(), 0, 30))));
		source.setSourceType(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getSourceType(), 0, 50))));
		source.setTimezone(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.substring(StringUtils.trim(StringUtils.substring(RoviTimeZoneUtil.getTimeZoneCode(source.getTimezone()), 0, 30)),0,4)));	
		source.setCity(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getCity(), 0, 50))));
		source.setState(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getState(), 0, 50))));
		source.setCountry(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getCountry(), 0, 255))));
		source.setOtaChannelNumber(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(source.getOtaChannelNumber())));
		source.setDigitalChannelNumber(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(source.getDigitalChannelNumber())));
		source.setVirtualChannelNumber(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(source.getVirtualChannelNumber())));
		source.setDmaName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(source.getDmaName())));
		source.setPrimaryLanguage(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getPrimaryLanguage(), 0, 30))));
		source.setTvRatingTypeUsed(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getTvRatingTypeUsed(), 0, 5))));
		source.setMovieRatingBoardUsed(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(source.getMovieRatingBoardUsed(), 0, 5))));
		
		if(source.getIsHdtv().equals("0"))
			source.setHdtvYn("N");
		else
			source.setHdtvYn("Y");
		
		return source;
	}
}


