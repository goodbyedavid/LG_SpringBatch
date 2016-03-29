package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Channellineup;

public class ChannellineupRowMapper implements RowMapper<Channellineup> {

	@Override
	public Channellineup mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Channellineup channellineup = new Channellineup();
		
		channellineup.setHeadendID(rs.getString("Headend ID"));
		channellineup.setSourceID(rs.getString("Source ID"));
		channellineup.setCallLetters(rs.getString("Call Letters"));
		channellineup.setChannelDevice(rs.getString("Channel Device"));
		channellineup.setChannelNumber(rs.getString("Channel Number"));
		channellineup.setEffectiveDate(rs.getString("Effective Date"));
		channellineup.setExpirationDate(rs.getString("Expiration Date"));
		channellineup.setEffectiveFlag(rs.getString("Effective Flag"));
		
		return channellineup;
	}
}
