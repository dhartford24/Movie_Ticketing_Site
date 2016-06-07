package com.dhartford.mts.service.interf;

import com.dhartford.mts.entity.interf.Rating;

public interface RatingService {
	
	Rating addRating(Rating rating);
	
	Rating getRating(long id);

}
