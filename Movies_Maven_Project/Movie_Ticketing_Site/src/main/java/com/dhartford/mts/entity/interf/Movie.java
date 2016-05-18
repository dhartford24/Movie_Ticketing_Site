package com.dhartford.mts.entity.interf;

import java.util.List;

public interface Movie {

	long getMovieId();
	String getMovieName();
	Genre getGenre();
	int getRuntime();
	Rating getRating();
	
	List<Theater> getTheaters();
	void addTheater(Theater theater);
} //end class
