package com.dhartford.mts.entity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.dhartford.mts.entity.interf.Genre;
import com.dhartford.mts.entity.interf.Movie;
//import com.dhartford.mts.entity.interf.Rating;
import com.dhartford.mts.entity.interf.Theater;

@Entity
@Table (name="movies")
public class MovieImpl implements Movie {
	
	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long movieId;
	
	@Column(name="movie_title")
	private String movieName;
	
	@ManyToOne(targetEntity=GenreImpl.class)
	@JoinColumn(name="genres_name")	
	private String genre;
	
	@Column(name="runtime")
	private int runtime;
	
	@ManyToOne(targetEntity=RatingImpl.class)
	@JoinColumn(name="ratings_name")
	private String rating;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "theaterName", targetEntity=TheaterImpl.class)
	private List<Theater> theaters; 
	
	
	public MovieImpl() {}
	
	public MovieImpl(String movieName) {
		this.movieName = movieName;
	}
	
	public long getMovieId() {
		return this.movieId;
	}
	
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return this.movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getRuntime() {
		return this.runtime;
	}
	
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public List<Theater> getTheaters() {
		return theaters;
	}
	
	public void addTheater(Theater theater) {
		if(theaters==null) {
			theaters = new ArrayList<Theater>();
		}
		theaters.add(theater);
	}
	
	@Override
	public String toString() {
		return this.getMovieName() + "\n" +
				this.getRating() + "\n" +
				this.getGenre() + "\n" +
				this.getRuntime() + "\n";
	}
}
