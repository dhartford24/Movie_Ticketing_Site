package com.dhartford.mts.repository;

import com.dhartford.mts.entity.interf.Movie;

public interface MovieRepository {

	/**
	 * 
	 * @param movie
	 * @return the id of the newly added movie
	 */
	
	long addMovie(Movie movie);
	
	Movie getMovie(long movieId);
}
