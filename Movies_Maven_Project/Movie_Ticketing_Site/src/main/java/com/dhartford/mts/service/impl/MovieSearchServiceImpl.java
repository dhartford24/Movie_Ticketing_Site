package com.dhartford.mts.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.repository.MovieRepository;
import com.dhartford.mts.service.exception.InvalidFieldException;
import com.dhartford.mts.service.exception.MTSException;
import com.dhartford.mts.service.interf.MovieSearchService;
import com.dhartford.mts.service.exception.ErrorCode;


@Service
public class MovieSearchServiceImpl implements MovieSearchService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Movie getMovieViaId(long movieId) {
		return movieRepository.getMovie(movieId);
	}
	
	@Override
	@Transactional
	public Movie addMovie(Movie movie) {
		if (StringUtils.isEmpty(movie.getMovieName())) {
			throw new InvalidFieldException("Movie name is required");
		}
		if (StringUtils.isEmpty(movie.getGenre())) {
			throw new InvalidFieldException("Genre is required");
		}
		if (StringUtils.isEmpty(movie.getRating())) {
			throw new InvalidFieldException("Movie rating is required");
		}
		if (StringUtils.isEmpty(movie.getRuntime())) {
			throw new InvalidFieldException("Movie runtime is required");
		}
		
		long id = movieRepository.addMovie(movie);
		return getMovieViaId(id);
	}
	
	@Override
	@Transactional
	public void updateMovie(Movie movie) {
		movieRepository.update(movie);
	}
	
	public List<Movie> getMoviesViaGenre(String genre) {
		List<Movie> myMovies = new ArrayList<>();
		if(StringUtils.isEmpty(genre)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myMovies = movieRepository.getMoviesByGenre(genre);
		}
		return myMovies;
	}
	
	@Override
	@Transactional
	public List<Movie> getMovies(String movieName) {
		List<Movie> returnList = new ArrayList<>();
		if (StringUtils.isEmpty(movieName)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		}
		else {
			returnList = movieRepository.search(movieName);
		}
		return returnList;
	}
	
	public Movie getMovieViaName(String movieName) {
		
		 return movieRepository.getMovieByName(movieName);
	}
	
	public List<Movie> getMoviesViaTheater(String theaterName) {
		List<Movie> myMovies = new ArrayList<>();
		if(StringUtils.isEmpty(theaterName)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myMovies = movieRepository.getMoviesByTheater(theaterName);
		}
		return myMovies;
	}
	
	public List<Movie> getMoviesViaRating(String rating) {
		List<Movie> myMovies = new ArrayList<>();
		if(StringUtils.isEmpty(rating)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myMovies = movieRepository.getMoviesByRating(rating);
		}
		return myMovies;
	}
	
} //end class
