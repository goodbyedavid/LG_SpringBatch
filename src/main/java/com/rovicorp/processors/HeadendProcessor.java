package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Headend;
import com.rovicorp.utils.RoviStringUtils;

public class HeadendProcessor implements ItemProcessor<Headend, Headend> {
	
	private static final Logger logger = LoggerFactory.getLogger(HeadendProcessor.class);

	@Override
	public Headend process(Headend headend) throws Exception {
		
		logger.trace("Processing Heandend HeadendID: [{}]", headend.getHeadendID());


		headend.setDmaCode(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getDmaCode())));
		headend.setSystemName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(headend.getSystemName(), 0, 60))));
		headend.setHeadendCity(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getHeadendCity())));
		headend.setHeadendState(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getHeadendState())));
		headend.setHeadendTimezone(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getHeadendTimezone())));
		headend.setObservesDST(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(headend.getObservesDST(), 0, 1))));
		headend.setDmaName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getDmaName())));
		headend.setDeviceType(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getDeviceType())));
		//headend.setHeadendName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(StringUtils.substring(headend.getHeadendName(), 0, 128))));
		
		headend.setHeadendName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(headend.getSystemName()) +' '+StringUtils.trim(headend.getPsaCity())  +' '+ StringUtils.trim(headend.getCableServiceName())));

		return headend;
	}
}
