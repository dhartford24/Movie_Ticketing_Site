package com.dhartford.mts.repository;

import java.util.List;

import com.dhartford.mts.entity.interf.Theater;

public interface TheaterRepository {
	
	/**
	 * @param theater
	 * @return the id of the newly added theater
	 */

	long addTheater(Theater theater);
	
	Theater getTheater(long theaterId);
	
	Theater getTheaterByName(String theaterName);
	
	List<Theater> getTheatersByMovie(String movieName);
	
	List<Theater> getTheatersByLocation(String location);
	
	List<Theater> getTheatersByQuality(int quality);
	
	List<Theater> getTheatersByNumScreens(int screens);
	
	void update(Theater theater);
}
