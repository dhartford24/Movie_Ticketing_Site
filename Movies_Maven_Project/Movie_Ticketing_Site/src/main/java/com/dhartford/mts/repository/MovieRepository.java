package com.dhartford.mts.repository;

import java.util.List;

import com.dhartford.mts.entity.interf.Movie;

public interface MovieRepository {

	/**
	 * 
	 * @param movie
	 * @return the id of the newly added movie
	 */
	
	long addMovie(Movie movie);
	
	Movie getMovie(long movieId);
	
	Movie getMovieByName(String movieName);
	
	List<Movie> getMoviesByGenre(String genre);
	
	List<Movie> getMoviesByRating(String rating);
	
	List<Movie> getMoviesByTheater(String theaterName);
	
	List<Movie> search(String movieName);
	
	void update(Movie movie);
}
