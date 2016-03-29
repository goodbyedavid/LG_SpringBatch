package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Source;

public class SourceRowMapper implements RowMapper<Source> {

	@Override
	public Source mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Source source = new Source();
		
		source.setSourceID(rs.getString("Source ID"));
		source.setShortName(rs.getString("Short Name"));
		source.setFullName(rs.getString("Full Name"));
		source.setCallLetters(rs.getString("Call Letters"));
		source.setOfficialCallSign(rs.getString("Official Call Sign"));
		source.setAffiliate1(rs.getString("Affiliate 1"));
		source.setAffiliate2(rs.getString("Affiliate 2"));
		source.setAffiliate3(rs.getString("Affiliate 3"));
		source.setSourceType(rs.getString("Source Type"));
		source.setTimezone(rs.getString("Time Zone"));
		source.setDst(rs.getString("DST"));
		source.setCity(rs.getString("City"));
		source.setState(rs.getString("State"));
		source.setCountry(rs.getString("Country"));
		source.setOtaChannelNumber(rs.getString("OTA Channel Number"));
		source.setDigitalSource(rs.getString("Digital Source"));
		source.setDigitalChannelNumber(rs.getString("Digital Channel Number"));
		source.setPsipVctActive(rs.getString("PSIP VCT Active"));
		source.setVirtualChannelNumber(rs.getString("Virtual Channel Number"));
		source.setAnalogPartnerID(rs.getString("Analog Partner ID"));
		source.setDmaRank(rs.getString("DMA Rank"));
		source.setDmaName(rs.getString("DMA Name"));
		source.setOwnedOperated(rs.getString("Owned Operated"));
		source.setPrimaryLanguage(rs.getString("Primary Language"));
		source.setTvRatingTypeUsed(rs.getString("TV Rating Type Used"));
		source.setMovieRatingBoardUsed(rs.getString("Movie Rating Board Used"));
		source.setIsHdtv(rs.getString("Is HDTV"));
		source.setIsSap(rs.getString("Is SAP"));
		source.setHdtvYn(rs.getString("HDTV yn"));
		
		return source;
	}
}
