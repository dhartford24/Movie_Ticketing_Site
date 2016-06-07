package com.dhartford.mts.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dhartford.mts.entity.interf.Genre;

@Entity
@Table (name="genres")
public class GenreImpl implements Genre{

	@Id
	@Column(name="genre_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long genreId;
	
	@Column(name="name")
	private String genre;
	
	public GenreImpl() {}
	
	public GenreImpl(String genre) {
		this.genre = genre;
	}
	
	public long getGenreId() {
		return this.genreId;
	}
	
	public void setGenreId(long genreId) {
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
