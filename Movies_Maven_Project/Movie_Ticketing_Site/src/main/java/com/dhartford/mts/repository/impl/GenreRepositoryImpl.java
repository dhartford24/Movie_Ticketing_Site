package com.dhartford.mts.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhartford.mts.entity.impl.GenreImpl;
import com.dhartford.mts.entity.interf.Genre;
import com.dhartford.mts.repository.GenreRepository;

@Repository
public class GenreRepositoryImpl implements GenreRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public long addGenre(Genre genre) {
		return (Long) this.sessionFactory.getCurrentSession().save(genre); 
	}
	
	public Genre getGenre(long genreId) {
		return (Genre) this.sessionFactory.getCurrentSession().get(GenreImpl.class, genreId);
	}
	
}
