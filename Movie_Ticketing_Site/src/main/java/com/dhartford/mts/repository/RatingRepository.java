package com.dhartford.mts.repository;

import com.dhartford.mts.entity.interf.Rating;

public interface RatingRepository {

	/**
	 * 
	 * @param rating
	 * @return the id of the newly added rating
	 */
	
	long addRating(Rating rating);
	
	Rating getRating(long ratingId);
}
