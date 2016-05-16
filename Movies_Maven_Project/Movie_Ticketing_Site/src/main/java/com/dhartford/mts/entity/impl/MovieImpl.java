package com.dhartford.mts.entity.impl;

import com.dhartford.mts.entity.interf.Movie;


public class MovieImpl implements Movie {
	
	private String movieName;
	private String genre;
	private int runtime;
	private String rating;
	private boolean comingSoon;
	
	public MovieImpl(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieName() {
		return this.movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getRuntime() {
		return this.runtime;
	}
	
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public boolean getComingSoon() {
		return this.comingSoon;
	}
	
	public void setComingSoon(boolean comingSoon) {
		this.comingSoon = comingSoon;
	}
	
	@Override
	public String toString() {
		return this.getMovieName() + "\n" +
				this.getRating() + "\n" +
				this.getGenre() + "\n" +
				this.getRuntime() + "\n" +
				"Coming Soon: " + this.getComingSoon() + "\n";
	}
}
