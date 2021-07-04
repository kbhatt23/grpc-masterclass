package com.learning.user_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learning.user_service.models.Movie;

public class MoviesDBService {

	// just mimicking the D.B

	private static final Map<String, List<Movie>> DATA;

	static {

		DATA = new HashMap<>();
		DATA.put("horror",
				Arrays.asList(Movie.newBuilder().setGenre("horror").setName("psycho").build(),
						Movie.newBuilder().setGenre("horror").setName("conjuring").build(),
						Movie.newBuilder().setGenre("horror").setName("annabelle").build()
						));
		
		DATA.put("thriller",Arrays.asList(
				Movie.newBuilder().setGenre("thriller").setName("dial m for murder").build(),
				Movie.newBuilder().setGenre("thriller").setName("kaala").build(),
				Movie.newBuilder().setGenre("thriller").setName("poirot").build(),
				Movie.newBuilder().setGenre("thriller").setName("feluda").build()));
		
		
	}

	public static List<Movie> findMovieByGenre(String genre) {

		if (DATA.containsKey(genre)) {
			return DATA.get(genre);
		} else {
			return new ArrayList<>();
		}
	}

}
