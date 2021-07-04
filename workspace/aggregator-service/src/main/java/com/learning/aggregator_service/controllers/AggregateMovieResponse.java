package com.learning.aggregator_service.controllers;

import java.util.List;

public class AggregateMovieResponse {

	List<String> movies;

	public AggregateMovieResponse(List<String> movies) {
		super();
		this.movies = movies;
	}

	public AggregateMovieResponse() {
		super();
	}

	public List<String> getMovies() {
		return movies;
	}

	public void setMovies(List<String> movies) {
		this.movies = movies;
	}
	
	
}
