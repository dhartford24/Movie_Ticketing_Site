package com.dhartford.mts.repository;

import com.dhartford.mts.entity.interf.Genre;

public interface GenreRepository {

	/**
	 * 
	 * @param genre
	 * @return the id of the newly added genre
	 */
	
	long addGenre(Genre genre);
	
	Genre getGenre(long genreId);
	
}
