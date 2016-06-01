package com.dhartford.mts.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dhartford.mts.entity.interf.Rating;

@Entity
@Table (name="ratings")
public class RatingImpl implements Rating {

	@Id
	@Column(name="rating_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;
	
	@Column(name="name")
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
