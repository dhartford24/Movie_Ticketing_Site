package com.dhartford.mts.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhartford.mts.entity.impl.RatingImpl;
import com.dhartford.mts.entity.interf.Rating;
import com.dhartford.mts.repository.RatingRepository;

@Repository
public class RatingRepositoryImpl implements RatingRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public long addRating(Rating rating) {
		return (Long) this.sessionFactory.getCurrentSession().save(rating); 
	}
	
	public Rating getRating(long ratingId) {
		return (Rating) this.sessionFactory.getCurrentSession().get(RatingImpl.class, ratingId);
	}
	
}
