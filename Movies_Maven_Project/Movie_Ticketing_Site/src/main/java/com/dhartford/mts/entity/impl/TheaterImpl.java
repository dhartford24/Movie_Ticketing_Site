package com.dhartford.mts.entity.impl;

import com.dhartford.mts.entity.interf.Theater;

public class TheaterImpl implements Theater {
	
	private String theaterName;
	private String location;
	private String showtime;
	private int qualityRating;
	private int numScreens;
	
	public TheaterImpl (String theaterName) {
		this.theaterName = theaterName;
	}
	
	public String getTheaterName() {
		return this.theaterName;
	}
	
	public String getTheaterLocation() {
		return this.location;
	}
	
	public String getShowtime() {
		return this.showtime;
	}
	
	public int getQualityRating() {
		return this.qualityRating;
	}
	
	public int getNumberOfScreens() {
		return this.numScreens;
	}

}
