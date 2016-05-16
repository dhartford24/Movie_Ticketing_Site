package com.dhartford.mts.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhartford.mts.entity.impl.MovieImpl;
import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.service.interf.MovieSearchService;


@Service
public class MovieSearchServiceImpl implements MovieSearchService {

	@Autowired
	private Movie movie;
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Movie getMovieViaName(String movieName) {
		return new MovieImpl(movieName);
	}
	
	
	public boolean isMovieComingSoon(boolean comingSoon) {
		if (comingSoon == true) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Movie> getMoviesViaGenre(String genre) {
		//get movies from database
		
		return null;
	}
	
	public ArrayList<Movie> getMoviesViaRuntime(int runtime) {
		/*
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		int numMovies = 5; //would really get numMovies from amount in database
		
		for(int i = 0; i < numMovies; i++) {
			//Search database for runtimes
			if (//movie retrieved runtime < runtime)
			{
				MovieImpl movieFound = new MovieImpl(//movieName retrieved);
				myMovies.add(movieFound);
			}

		} //end for
		return myMovies;
		*/
		return null;
	}
	
	public ArrayList<Movie> getMoviesComingSoon(boolean comingSoon) {
		if (comingSoon = true) {
			//get movies from database
		}
		return null;
	}
	
	public ArrayList<Movie> getMoviesViaRating(String rating) {
		/*get movies from database
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		
		for (int i = 0; i < moviesInDataBase.length; i++) {
			//Search database for genres
			if (rating = "G") {
				MovieImpl moviesG = new MovieImpl(movieName retrieved);
				myMovies.add(movieFound);
			}
		} //end for
		return myMovies;
		*/
		return null;
	}
	
} //end class
