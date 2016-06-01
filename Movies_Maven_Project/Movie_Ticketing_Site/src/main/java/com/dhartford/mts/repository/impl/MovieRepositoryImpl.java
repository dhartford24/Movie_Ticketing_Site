package com.dhartford.mts.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.dhartford.mts.entity.impl.MovieImpl;
import com.dhartford.mts.entity.impl.TheaterImpl;
import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long addMovie(Movie movie) {
		return (Long) this.sessionFactory.getCurrentSession().save(movie); 
	}
	
	@Override
	public Movie getMovie(long movieId) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}
	
	@Override
	public Movie getMovieByName(String movieName) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMoviesByTheater(String theaterName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("theaterName", theaterName)); //did I do this right???
		List<Movie> myMovies = crit.list();
		return myMovies;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("genre", genre));  //do I have the right property set here???
		List<Movie> myMovies = crit.list();
		return myMovies;
		
	} //end getMoviesByGenre
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMoviesByRating(String rating) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("rating", rating));	//do I have the right property set here???
		List<Movie> myMovies = crit.list();
		return myMovies;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> search(String movieName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Movie.class);
		if (!StringUtils.isEmpty(movieName)) {
			crit.add(Restrictions.like("movieName", "%"+movieName+"%"));
		}
		List<Movie> searchResult = crit.list();
		return searchResult;
	}
	
	@Override
	public void update(Movie movie) {
		this.sessionFactory.getCurrentSession().update(movie);		
	}
	
}
