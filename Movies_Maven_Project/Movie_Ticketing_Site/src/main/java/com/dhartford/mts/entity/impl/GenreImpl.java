package com.dhartford.mts.entity.impl;

import com.dhartford.mts.entity.interf.Genre;

public class GenreImpl implements Genre{

	private int genreId;
	private String genre;
	
	public GenreImpl() {}
	
	public GenreImpl(String genre) {
		this.genre = genre;
	}
	
	public int getGenreId() {
		return this.genreId;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "The genre of this movie is: " + this.genre;
	}
	
}
