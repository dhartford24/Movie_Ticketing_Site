package com.dhartford.mts.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhartford.mts.entity.impl.MovieImpl;
import com.dhartford.mts.entity.interf.Movie;
import com.dhartford.mts.http.entity.HttpMovie;
import com.dhartford.mts.service.exception.MTSException;
import com.dhartford.mts.service.interf.MovieSearchService;

@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieSearchService movieSearchService;
	
	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie) {
		Movie movieToCreate = convert(newMovie);
		Movie addedMovie = movieSearchService.addMovie(movieToCreate);
		return Response.status(Status.CREATED).header("Location", "/movies/"+addedMovie.getMovieId()).entity(new HttpMovie(addedMovie)).build();
	}
	
	@GET
	@Path("/{movieId}")
	public HttpMovie getMovieById(@PathParam("movieId") long movieId) {
		logger.info("getting movie by id:"+movieId);
		Movie movie = movieSearchService.getMovieViaId(movieId);
		return new HttpMovie(movie);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="movies")
	public List<HttpMovie> getMovieSearch(@QueryParam("movieName") String movieName, @QueryParam("genre") String genre,
			@QueryParam("rating") String rating, @QueryParam("runtime") int runtime) throws MTSException {
		logger.info("movie search movieName="+movieName + " genre="+genre + " rating="+rating + " runtime="+runtime);
		List<Movie> found = movieSearchService.getMovies(movieName);
		List<HttpMovie> returnList = new ArrayList<>(found.size());
		for (Movie movie:found) {
			returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpMovie.movieName);
		movie.setGenre(httpMovie.genre);
		movie.setRating(httpMovie.rating);
		movie.setRuntime(httpMovie.runtime);
		return movie;
	}
}
