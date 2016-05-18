package com.dhartford.mts.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhartford.mts.entity.impl.MovieImpl;
import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public long addMovie(Movie movie) {
		return (Long) this.sessionFactory.getCurrentSession().save(movie); 
	}
	
	public Movie getMovie(long movieId) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}
	
}
