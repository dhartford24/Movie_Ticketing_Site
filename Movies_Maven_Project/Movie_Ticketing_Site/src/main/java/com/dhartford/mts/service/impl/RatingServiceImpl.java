package com.dhartford.mts.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhartford.mts.entity.interf.Rating;
import com.dhartford.mts.repository.RatingRepository;
import com.dhartford.mts.service.interf.RatingService;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating addRating(Rating rating) {
		long newId = ratingRepository.addRating(rating);
		return ratingRepository.getRating(newId);
	}
	
	@Override
	public Rating getRating(long id) {
		return ratingRepository.getRating(id);
	}
	
}
