package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Mso;
import com.rovicorp.utils.RoviStringUtils;

public class MsoProcessor implements ItemProcessor<Mso, Mso> {
	

	private static final Logger logger = LoggerFactory.getLogger(MsoProcessor.class);

	@Override
	public Mso process(Mso mso) throws Exception {
		
		logger.trace("Processing MSO MsoID: [{}]", mso.getMsoID());

		mso.setMsoName(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.trim(mso.getMsoName())));
		
		return mso;
	}
}
