package com.dhartford.mts.service.interf;

import java.util.List;

import com.dhartford.mts.entity.interf.Theater;

public interface TheaterService {
	
	Theater getTheaterViaId(long theaterId);
	
	Theater addTheater(Theater theater);
	
	void updateTheater(Theater theater);
	
	List<Theater> getTheatersViaLocation(String location);
	
	List<Theater> getTheatersViaQuality(int quality);
	
	Theater getTheaterViaName(String theaterName);
	
	List<Theater> getTheatersViaScreens(int screens);
	
	List<Theater> getTheatersViaMovie(String movieName);
}
