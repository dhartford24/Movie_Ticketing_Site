package com.dhartford.mts.entity.interf;

import java.util.List;

public interface Movie {

	long getMovieId();
	String getMovieName();
	String getGenre();
	int getRuntime();
	String getRating();
	
	List<Theater> getTheaters();
	void addTheater(Theater theater);
} //end class
