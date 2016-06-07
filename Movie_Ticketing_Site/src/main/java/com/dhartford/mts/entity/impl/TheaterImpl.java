package com.dhartford.mts.entity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.entity.interf.Theater;

@Entity
@Table(name="theaters")
public class TheaterImpl implements Theater {
	@Id
	@Column(name="theater_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long theaterId;
	
	@Column(name="name")
	private String theaterName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="quality")
	private int qualityRating;
	
	@Column(name="screens")
	private int numScreens;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "movieName", targetEntity=MovieImpl.class)	
	private List<Movie> movies;
	
	
	public TheaterImpl() {}
	
	public TheaterImpl (String theaterName) {
		this.theaterName = theaterName;
	}
	
	public long getTheaterId() {
		return this.theaterId;
	}
	
	public void setTheatertId(long theaterId) {
		this.theaterId = theaterId;
	}
	
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
	public String getTheaterName() {
		return this.theaterName;
	}
	
	public void setTheaterLocation(String location) {
		this.location = location;
	}
	
	public String getTheaterLocation() {
		return this.location;
	}
	
	public void setQualityRating(int qualityRating) {
		this.qualityRating = qualityRating;
	}
	
	public int getQualityRating() {
		return this.qualityRating;
	}
	
	public void setNumberOfScreens(int numScreens) {
		this.numScreens = numScreens;
	}
	
	public int getNumberOfScreens() {
		return this.numScreens;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void addMovie(Movie movie) {
		if(movies==null){
			movies = new ArrayList<Movie>();
		}
		movies.add(movie);
	}
	
	@Override
	public String toString() {
		return this.theaterName + " at " +
				this.location + " has a quality rating of " +
				this.qualityRating + " out of 10, and has " +
				this.numScreens + " number of movie screens";
	}

}
