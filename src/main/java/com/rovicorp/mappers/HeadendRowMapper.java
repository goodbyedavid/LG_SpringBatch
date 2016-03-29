package com.rovicorp.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rovicorp.dto.Headend;

public class HeadendRowMapper implements RowMapper<Headend> {

	@Override
	public Headend mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Headend headend = new Headend();
		
		headend.setHeadendID(rs.getString("Headend ID"));
		headend.setDmaCode(rs.getString("DMA Code"));
		headend.setDmaRank(rs.getString("DMA Rank"));
		headend.setSystemName(rs.getString("System Name"));
		headend.setHeadendCity(rs.getString("Headend City"));
		headend.setHeadendState(rs.getString("Headend State"));
		headend.setHeadendTimezone(rs.getString("Headend Time Zone"));
		headend.setObservesDST(rs.getString("Observes DST"));
		headend.setMsoID(rs.getString("MSO ID"));
		headend.setDmaName(rs.getString("DMA Name"));
		headend.setDeviceType(rs.getString("Device Type"));
		//headend.setHeadendName(rs.getString("Headend Name"));
		headend.setPsaCity(rs.getString("psaCity"));
		headend.setCableServiceName(rs.getString("cableServiceName"));
		
		
		return headend;
	}
}
