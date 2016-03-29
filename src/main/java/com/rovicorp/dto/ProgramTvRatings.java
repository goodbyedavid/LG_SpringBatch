package com.rovicorp.dto;

public class ProgramTvRatings {
	
	private String programID;
	private String tvRatingType;
	private String NAME;
	private String tvRating;
    private String tvAdvisory;
    
	public String getProgramID() {
		return programID;
	}
	public void setProgramID(String programID) {
		this.programID = programID;
	}
	public String getTvRatingType() {
		return tvRatingType;
	}
	public void setTvRatingType(String tvRatingType) {
		this.tvRatingType = tvRatingType;
	}
	public String getName(){
		return NAME;
	}
	public void setName(String NAME){
		this.NAME = NAME;
	}
	public String getTvRating() {
		return tvRating;
	}
	public void setTvRating(String tvRating) {
		this.tvRating = tvRating;
	}
	public String getTvAdvisory() {
		return tvAdvisory;
	}
	public void setTvAdvisory(String tvAdvisory) {
		this.tvAdvisory = tvAdvisory;
	} 
}
