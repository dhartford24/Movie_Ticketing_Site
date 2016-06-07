package com.dhartford.mts.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dhartford.mts.entity.impl.MovieImpl;
import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.service.interf.MovieSearchService;

@ContextConfiguration(locations = {"classpath:spring-context-movies.xml"})
public class TestMovieSearchService extends AbstractJUnit4SpringContextTests {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieSearchService movieSearchService;

	@Test
	public void addAndGetMovie() {
		
		MovieImpl newMovie = new MovieImpl();
		newMovie.setMovieName("Star Wars");
		newMovie.setGenre("Science Fiction");
		newMovie.setRating("PG-13");
		newMovie.setRuntime(120);
		
		Movie added = movieSearchService.addMovie(newMovie);
		logger.info("movie added" + added);
		Assert.assertNotEquals(0, added.getMovieId());
		Assert.assertEquals(newMovie.getMovieName(), added.getMovieName());
		Assert.assertEquals(newMovie.getGenre(), added.getGenre());
		Assert.assertEquals(newMovie.getRating(), added.getRating());
		Assert.assertEquals(newMovie.getRuntime(), added.getRuntime());
		
		Movie found = movieSearchService.getMovieViaId(added.getMovieId());
		Assert.assertEquals(found.getMovieId(), added.getMovieId());
		Assert.assertEquals(found.getMovieName(), added.getMovieName());
		Assert.assertEquals(found.getGenre(), added.getGenre());
		Assert.assertEquals(found.getRating(), added.getRating());
		Assert.assertEquals(found.getRuntime(), added.getRuntime());
		
	} //end addAndGetMovie
	
	@Test
	public void testGetMovieViaName() {
		
		MovieImpl newMovie1 = new MovieImpl();
		newMovie1.setMovieName("Star Wars");
		newMovie1.setGenre("Science Fiction");
		newMovie1.setRating("PG-13");
		newMovie1.setRuntime(120);
		
		MovieImpl newMovie2 = new MovieImpl();
		newMovie2.setMovieName("Dumb and Dumber");
		newMovie2.setGenre("Comedy");
		newMovie2.setRating("PG-13");
		newMovie2.setRuntime(95);
		
		Movie added1 = movieSearchService.addMovie(newMovie1);
		Movie added2 = movieSearchService.addMovie(newMovie2);
		logger.info("movie added " + added1);
		logger.info("movie added " + added2);
		
		Movie found1 = movieSearchService.getMovieViaName("Star Wars");
		Movie found2 = movieSearchService.getMovieViaName("Dumb and Dumber");
		
		Assert.assertEquals(found1.getMovieId(), added1.getMovieId());
		Assert.assertEquals(found1.getMovieName(), added1.getMovieName());
		Assert.assertEquals(found1.getGenre(), added1.getGenre());
		Assert.assertEquals(found1.getRating(), added1.getRating());
		Assert.assertEquals(found1.getRuntime(), added1.getRuntime());
		
		Assert.assertEquals(found2.getMovieId(), added2.getMovieId());
		Assert.assertEquals(found2.getMovieName(), added2.getMovieName());
		Assert.assertEquals(found2.getGenre(), added2.getGenre());
		Assert.assertEquals(found2.getRating(), added2.getRating());
		Assert.assertEquals(found2.getRuntime(), added2.getRuntime());
	}

}
