package com.dhartford.mts.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.dhartford.mts.entity.interf.Theater;
import com.dhartford.mts.repository.TheaterRepository;
import com.dhartford.mts.service.exception.ErrorCode;
import com.dhartford.mts.service.exception.InvalidFieldException;
import com.dhartford.mts.service.exception.MTSException;
import com.dhartford.mts.service.interf.TheaterService;

public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;
	
	public Theater getTheaterViaId(long theaterId) {
		return theaterRepository.getTheater(theaterId);
	}
	
	@Override
	@Transactional
	public Theater addTheater(Theater theater) {
		if (StringUtils.isEmpty(theater.getNumberOfScreens())) {
			throw new InvalidFieldException("Number of screens is required");
		}
		if (StringUtils.isEmpty(theater.getQualityRating())) {
			throw new InvalidFieldException("Theater quality is required");
		}
		if (StringUtils.isEmpty(theater.getTheaterLocation())) {
			throw new InvalidFieldException("Theater location is required");
		}
		if (StringUtils.isEmpty(theater.getTheaterName())) {
			throw new InvalidFieldException("Theater name is required");
		}
		
		long id = theaterRepository.addTheater(theater);
		return getTheaterViaId(id);
	}
	
	@Override
	@Transactional
	public void updateTheater(Theater theater) {
		theaterRepository.update(theater);
	}
	
	public List<Theater> getTheatersViaLocation(String location) {
		List<Theater> myTheaters = new ArrayList<>();
		if(StringUtils.isEmpty(location)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myTheaters = theaterRepository.getTheatersByLocation(location);
		}
		return myTheaters;
	}
	
	@Override
	@Transactional
	public List<Theater> getTheatersViaQuality(int quality) {
		List<Theater> myTheaters = new ArrayList<>();
		if(StringUtils.isEmpty(quality)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myTheaters = theaterRepository.getTheatersByQuality(quality);
		}
		return myTheaters;
	}
	
	@Override
	@Transactional
	public Theater getTheaterViaName(String theaterName) {
		return theaterRepository.getTheaterByName(theaterName);
	}
	
	@Override
	@Transactional
	public List<Theater> getTheatersViaScreens(int screens) {
		List<Theater> myTheaters = new ArrayList<>();
		if(StringUtils.isEmpty(screens)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myTheaters = theaterRepository.getTheatersByNumScreens(screens);
		}
		return myTheaters;
	}
	
	@Override
	@Transactional
	public List<Theater> getTheatersViaMovie(String movieName) {
		List<Theater> myTheaters = new ArrayList<>();
		if(StringUtils.isEmpty(movieName)) {
			throw new MTSException(ErrorCode.MISSING_DATA, "no search parameter provided");
		} //end if
		else {
			myTheaters = theaterRepository.getTheatersByMovie(movieName);
		}
		return myTheaters;
	}
	
}
