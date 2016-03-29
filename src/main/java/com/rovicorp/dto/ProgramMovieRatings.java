package com.rovicorp.dto;

public class ProgramMovieRatings {
	
	private String programID;
	private String movieRatingType;
	private String movieRating;
	private String movieRatingReason;
	private String NAME;
	
	public String getProgramID() {
		return programID;
	}
	public void setProgramID(String programID) {
		this.programID = programID;
	}
	public String getMovieRatingType() {
		return movieRatingType;
	}
	public void setMovieRatingType(String movieRatingType) {
		this.movieRatingType = movieRatingType;
	}
	public String getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}
	public String getMovieRatingReason() {
		return movieRatingReason;
	}
	public void setMovieRatingReason(String movieRatingReason) {
		this.movieRatingReason = movieRatingReason;
	}
	public String getNAME(){
		return NAME;
	}
	public void setNAME(String name){
		this.NAME = name;
	}
}
