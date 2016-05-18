package com.dhartford.mts.entity.impl;

import com.dhartford.mts.entity.interf.Rating;

public class RatingImpl implements Rating {

	private int ratingId;
	private String rating;
	
	public RatingImpl() {}
	
	public RatingImpl(String rating) {
		this.rating = rating;
	}
	
	public int getRatingId() {
		return this.ratingId;
	}
	
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
}
