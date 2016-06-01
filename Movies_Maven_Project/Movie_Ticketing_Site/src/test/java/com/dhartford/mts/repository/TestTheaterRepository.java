package com.dhartford.mts.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.dhartford.mts.entity.impl.TheaterImpl;
import com.dhartford.mts.entity.interf.Theater;

@ContextConfiguration(locations = {"classpath:spring-context-movies.xml"})
public class TestTheaterRepository extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired TheaterRepository theaterRepository;
	
	@Test
	public void addAndGetTheater() {
		
		TheaterImpl newTheater = new TheaterImpl();
		newTheater.setTheaterName("Century Theaters");
		newTheater.setNumberOfScreens(15);
		newTheater.setQualityRating(9);
		newTheater.setTheaterLocation("Monterey");
		
		long addedTheaterId = theaterRepository.addTheater(newTheater);
		System.out.println("Theater added id: " + addedTheaterId);
		Assert.assertNotEquals(0, addedTheaterId);
		
		Theater found = theaterRepository.getTheater(addedTheaterId);
		Assert.assertEquals(found.getTheaterId(), addedTheaterId);
		Assert.assertEquals(found.getTheaterName(), newTheater.getTheaterName());
		Assert.assertEquals(found.getTheaterLocation(), newTheater.getTheaterLocation());
		Assert.assertEquals(found.getNumberOfScreens(), newTheater.getNumberOfScreens());
		Assert.assertEquals(found.getQualityRating(), newTheater.getQualityRating());
		
	} //end addAndGetTheater

}
