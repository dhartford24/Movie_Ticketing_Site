package com.dhartford.mts.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.dhartford.mts.entity.interf.Movie;

@XmlRootElement(name = "movie")
public class HttpMovie {

	@XmlElement
	public long id;
	
	@XmlElement
	public String movieName;
	
	@XmlElement
	public String genre;
	
	@XmlElement
	public String rating;
	
	@XmlElement
	public int runtime;
	
	public HttpMovie() {}
	
	public HttpMovie(Movie movie) {
		this.id = movie.getMovieId();
		this.movieName = movie.getMovieName();
		this.genre = movie.getGenre();
		this.rating = movie.getRating();
		this.runtime = movie.getRuntime();
	}
	
	@Override
	public String toString() {
		return "HttpMovie [id=" + id + ", movieName=" + movieName
				+ ", genre=" + genre + ", rating=" + rating + ", runtime=" + runtime + "]";
	}
}
