package com.learning.aggregator_service.controllers;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.aggregator_service.models.MoviesListRequest;
import com.learning.aggregator_service.models.MoviesListResponse;
import com.learning.aggregator_service.models.MoviesListServiceGrpc.MoviesListServiceBlockingStub;
import com.learning.aggregator_service.models.UserGenreMessageRequest;
import com.learning.aggregator_service.models.UserGenreMessageResponse;
import com.learning.aggregator_service.models.UserGenreServiceGrpc.UserGenreServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;

@RestController
@RequestMapping("/aggregate")
public class AggreagtorController {

	
	@GrpcClient("user-service")
	private UserGenreServiceBlockingStub userStub;
	
	@GrpcClient("movie-service")
	private MoviesListServiceBlockingStub moviesStub;
	
	@GetMapping("/userID/{userID}")
	public AggregateMovieResponse findMoviesOfFavoruiteGenre(@PathVariable int userID) {
		
		UserGenreMessageResponse userGenreMessageResponse = userStub.favouriteGenre(UserGenreMessageRequest.newBuilder().setUserId(userID).build());
		
		MoviesListResponse findMoviesByGenre = moviesStub.findMoviesByGenre(MoviesListRequest.newBuilder().setGenre(userGenreMessageResponse.getFavouriteGenre()).build());
	
		return new AggregateMovieResponse(findMoviesByGenre.getMoviesList()
				.stream()
				.map(m -> m.getName())
				.collect(Collectors.toList())
				);
	}
	
}
