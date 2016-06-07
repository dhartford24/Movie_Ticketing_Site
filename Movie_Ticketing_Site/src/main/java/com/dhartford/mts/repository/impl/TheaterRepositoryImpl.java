package com.dhartford.mts.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	
	@Override
	public Theater getTheaterByName(String theaterName) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, theaterName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getTheatersByMovie(String movieName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("movieName", movieName));  //do I have the right property set here???  Do I put MovieImpl.class above???
		List<Theater> myTheaters = crit.list();
		return myTheaters;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getTheatersByLocation(String location) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("location", location));
		List<Theater> myTheaters = crit.list();
		return myTheaters;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getTheatersByQuality(int quality) {
		if (quality > 7 && quality <= 10) {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("quality", 11));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		} else if (quality > 3 && quality <= 7) {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("quality", 8));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		} else if (quality > 0 && quality <= 3) {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("quality", 4));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		} else {
			System.out.println("Sorry, quality of theater not found");
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getTheatersByNumScreens(int screens) {
		if (screens >= 5) {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("screens", 5));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		} else if (screens >= 10) {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("screens", 11));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		} else if (screens >= 15) {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("screens", 16));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		} else {
			Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
					.add(Restrictions.lt("screens", 21));
			List<Theater> myTheaters = crit.list();
			return myTheaters;
		}
	}
	
	@Override
	public void update(Theater theater) {
		this.sessionFactory.getCurrentSession().update(theater);		
	}
}
