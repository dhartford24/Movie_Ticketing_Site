package com.dhartford.mts.http;

import java.util.List;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dhartford.mts.http.entity.HttpMovie;
import com.dhartford.mts.http.exception.HttpError;

public class TestMovieResource {

	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "Movie_Ticketing_Site/rest/movies";
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}
	
	@Test
	public void testGetMoviesNoParamsJson(){						
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).get();
				
		verifyMissing(response);
	}
	
	@Test
	public void testGetMoviesNoParamsXml(){						
		Response response =	target.request().accept(MediaType.APPLICATION_XML).get();
		
		verifyMissing(response);
	}
	
	private void verifyMissing(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("MISSING_DATA", error.code);
		Assert.assertEquals("no search parameter provided", error.message);
		Assert.assertEquals("", error.debug);		
	}
	
	@Test
	public void testCreateMoviesNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<movie/>", MediaType.APPLICATION_XML));
		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateMoviesNoParamsEntityXml(){					
		HttpMovie movieToSend = new HttpMovie();		
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(movieToSend, MediaType.APPLICATION_XML));
		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateMoviesNoParamsJson(){					
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{movie:{}}", MediaType.APPLICATION_JSON));
		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateMoviesNoParamsEntityJson(){					
		HttpMovie movieToSend = new HttpMovie();		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
		
		verifyInvalid(response);
	}
	
	private void verifyInvalid(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("INVALID_FIELD", error.code);
		Assert.assertEquals("pin is required", error.message);
		Assert.assertEquals("", error.debug);		
	}
	
	@Test
	public void testCreateAndGetMovie() {
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieName="Star Wars"+new Random().nextInt(99999);
		movieToSend.genre="Science Fiction"+new Random().nextInt(99999);
		movieToSend.rating="PG-13";
		movieToSend.runtime=123;
		
		Response response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
		
		HttpMovie createResponse = response.readEntity(HttpMovie.class);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.movieName, movieToSend.movieName);
		Assert.assertEquals(createResponse.genre, movieToSend.genre);
		Assert.assertEquals(createResponse.rating, movieToSend.rating);
		Assert.assertEquals(createResponse.runtime, movieToSend.runtime);
		Assert.assertNotNull(createResponse.id);
		
		//search for created movie
		
		Response search = target.queryParam("movieName", movieToSend.movieName).queryParam("genre", movieToSend.genre).queryParam("rating", movieToSend.rating).queryParam("runtime", movieToSend.runtime).request().accept(MediaType.APPLICATION_JSON).get();
		List<HttpMovie> searchResponse = search.readEntity(new GenericType<List<HttpMovie>>(){});
		Assert.assertEquals(searchResponse.get(0), createResponse);
	}
	
}
