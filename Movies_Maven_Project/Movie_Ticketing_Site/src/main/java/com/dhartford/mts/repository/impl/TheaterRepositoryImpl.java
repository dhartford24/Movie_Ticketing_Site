package com.dhartford.mts.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhartford.mts.entity.impl.TheaterImpl;
import com.dhartford.mts.entity.interf.Theater;
import com.dhartford.mts.repository.TheaterRepository;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public long addTheater(Theater theater) {
		return (Long) this.sessionFactory.getCurrentSession().save(theater); 
	}
	
	public Theater getTheater(long theaterId) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, theaterId);
	}
}
