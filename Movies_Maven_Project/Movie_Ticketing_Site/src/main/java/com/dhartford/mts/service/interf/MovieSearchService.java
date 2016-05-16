package com.dhartford.mts.service.interf;

import java.util.ArrayList;

import com.dhartford.mts.entity.interf.Movie;

public interface MovieSearchService {

	Movie getMovieViaName(String movieName);
	
	boolean isMovieComingSoon(boolean comingSoon);
	
	ArrayList<Movie> getMoviesViaGenre(String genre);
	
	ArrayList<Movie> getMoviesViaRuntime(int runtime);
	
	ArrayList<Movie> getMoviesComingSoon(boolean comingSoon);
	
	ArrayList<Movie> getMoviesViaRating(String rating);
}
