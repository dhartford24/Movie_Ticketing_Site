package com.dhartford.mts.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.service.impl.MovieSearchServiceImpl;
import com.dhartford.mts.service.interf.MovieSearchService;

@ContextConfiguration(locations = {"classpath:spring-context-movies.xml"})
public class TestMovieSearchService extends AbstractJUnit4SpringContextTests {
	@Autowired
	private MovieSearchService movieSearchService;

	//@SuppressWarnings("resource")
	@Test
	public void testGetMovieViaName() {
		
		Movie movieGet = movieSearchService.getMovieViaName("Star Wars");
		
		/*
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring-context-movies.xml");
		
		MovieSearchServiceImpl mssi = (MovieSearchServiceImpl) context.getBean("movieSearchServiceImpl");
		
		
		Movie movieGet = mssi.getMovieViaName("Star Wars");
		*/
		
		Assert.assertTrue(movieGet instanceof Movie);
		Assert.assertEquals("Star Wars", movieGet.getMovieName());
		System.out.println(movieGet);
		
	} //end testGetMovieViaName

}
