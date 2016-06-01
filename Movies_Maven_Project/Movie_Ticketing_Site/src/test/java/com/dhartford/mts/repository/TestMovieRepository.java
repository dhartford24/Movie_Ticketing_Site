package com.dhartford.mts.repository;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.dhartford.mts.entity.impl.MovieImpl;
import com.dhartford.mts.entity.interf.Movie;

@ContextConfiguration(locations = {"classpath:spring-context-movies.xml"})
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private MovieRepository movieRepository;

	@Test
	public void addAndGetMovie(){
		MovieImpl newMovie = new MovieImpl();
		newMovie.setMovieName("test"+new Random().nextInt(99999));
		newMovie.setRuntime(123);
		
		long  addedMovieId = movieRepository.addMovie(newMovie);
		System.out.println("user added id "+addedMovieId);
		Assert.assertNotEquals(0, addedMovieId);		
		
		Movie found = movieRepository.getMovie(addedMovieId);
		Assert.assertEquals(found.getMovieId(), addedMovieId);
		Assert.assertEquals(found.getMovieName(), newMovie.getMovieName());
		Assert.assertEquals(found.getRuntime(), newMovie.getRuntime());
	}

}
