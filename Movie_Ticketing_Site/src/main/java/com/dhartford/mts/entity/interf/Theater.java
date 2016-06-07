package com.dhartford.mts.entity.interf;

import java.util.List;

public interface Theater {
	
	long getTheaterId();
	String getTheaterName();
	String getTheaterLocation();
	int getQualityRating();
	int getNumberOfScreens();
	
	List<Movie> getMovies();
	void addMovie(Movie movie);

}
