package com.dhartford.mts.repository;

import com.dhartford.mts.entity.interf.Theater;

public interface TheaterRepository {
	
	/**
	 * 
	 * @param theater
	 * @return the id of the newly added theater
	 */

	long addTheater(Theater theater);
	
	Theater getTheater(long theaterId);
}
