package com.dhartford.mts.service.interf;

import java.util.List;

import com.dhartford.mts.entity.interf.Movie;

public interface MovieSearchService {

	Movie getMovieViaId(long movieId);
	
	Movie addMovie(Movie movie);
	
	List<Movie> getMovies(String movieName);
	
	void updateMovie(Movie movie);
	
	List<Movie> getMoviesViaGenre(String genre);
	
	List<Movie> getMoviesViaTheater(String theaterName);
	
	Movie getMovieViaName(String movieName);
	
	List<Movie> getMoviesViaRating(String rating);
}
