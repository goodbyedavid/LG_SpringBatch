package com.rovicorp.processors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.rovicorp.dto.Program;
import com.rovicorp.utils.RoviProgramCopySmartCopyUtil;
import com.rovicorp.utils.RoviStringUtils;

public class ProgramProcessor implements ItemProcessor<Program, Program> {

	private static final Logger logger = LoggerFactory.getLogger(Program.class);
	@Override
	public Program process(Program program) throws Exception {
		
		logger.trace("Processing Program ProgramID: [{}]", program.getProgramID());
		if(program.getShowType() != null) {
			if(program.getShowType().equals("OTO"))
				program.setShowType("OT");
			else if(program.getShowType().equals("Series Episode"))
				program.setShowType("SE");
			else if(program.getShowType().equals("Series Master"))
				program.setShowType("SM");
			else
				program.setShowType("MO");
		}
		
		if(program.getProgramTypeID() != null && (program.getProgramTypeID().equals("2") || program.getProgramTypeID().equals("3")))
			if(program.getSeriesParentProgramID() == null)
				program.setSeriesID(program.getProgramID());
			else
				program.setSeriesID(program.getSeriesParentProgramID());
		else
			program.setSeriesID("");
		
		if(program.getOriginalAirDate() == null)
			program.setOriginalAirDate(StringUtils.stripToEmpty(program.getOriginalAirDateUS()));
		else
			program.setOriginalAirDate(program.getOriginalAirDate());
		
		program.setOriginalAirDate(StringUtils.substring(StringUtils.stripToEmpty(program.getOriginalAirDate()), 0, 10).replace("-", "").replace(" ", "T"));
		program.setEventDate(StringUtils.substring(StringUtils.stripToEmpty(program.getEventDate()), 0, 10).replace("-", "").replace(" ", "T"));
		

		program.setSmartCopyLong(RoviStringUtils.replaceAllSpecialCharacters(RoviProgramCopySmartCopyUtil.smartCopy(program.getCategoryId(), 2000, program.getChronoLong(), program.getChronoLongCuttingPositionlist(), program.getPromo(), program.getPromoCuttingPositionlist(), program.getChronoShort(), program.getChronoShortCuttingPositionlist(), program.getNoCast(), program.getNoCastCuttingPositionlist(), program.getGridCopy(), program.getGridCopyCuttingPositionlist())));
		program.setSmartCopyBrief(RoviStringUtils.replaceAllSpecialCharacters(RoviProgramCopySmartCopyUtil.smartCopy(program.getCategoryId(), 60, program.getChronoLong(), program.getChronoLongCuttingPositionlist(), program.getPromo(), program.getPromoCuttingPositionlist(), program.getChronoShort(), program.getChronoShortCuttingPositionlist(), program.getNoCast(), program.getNoCastCuttingPositionlist(), program.getGridCopy(), program.getGridCopyCuttingPositionlist())));
		program.setLongDescription(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.substring(StringUtils.stripToEmpty(program.getLongDescription()), 0, 500)));
		program.setLongTitle(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getLongTitle())));
		program.setMediumTitle(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getMediumTitle())));
		program.setShortTitle(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getShortTitle())));
		program.setGridTitle(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getGridTitle())));
		program.setSubtitle(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getSubtitle())));
		program.setGrid2Title(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getGrid2Title())));
		program.setEpisodeTitle(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getEpisodeTitle())));
		program.setEpisodeNumber(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getEpisodeNumber())));
		program.setCategory(RoviStringUtils.replaceAllSpecialCharacters(StringUtils.stripToEmpty(program.getCategory())));
	
		program.setRuntime(StringUtils.stripToEmpty(program.getRuntime()));
		program.setReleaseYear(StringUtils.stripToEmpty(program.getReleaseYear()));
		program.setProgramLanguage(StringUtils.stripToEmpty(program.getProgramLanguage()));
		program.setStarRating(StringUtils.stripToEmpty(program.getStarRating()));
		
		if(program.getAudioLevel() == null)
			program.setAudioLevel("None");
		program.setMovieType(StringUtils.stripToEmpty(program.getMovieType()));
		if(program.getHdtvLevel() == null)
			program.setHdtvLevel("None");	
		
		return program;
	}
}