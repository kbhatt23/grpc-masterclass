package com.learning.user_service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.learning.user_service.models.Movie;
import com.learning.user_service.models.MoviesListRequest;
import com.learning.user_service.models.MoviesListResponse;
import com.learning.user_service.models.MoviesListServiceGrpc.MoviesListServiceImplBase;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MoviesListServiceImpl extends MoviesListServiceImplBase{

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void findMoviesByGenre(MoviesListRequest request, StreamObserver<MoviesListResponse> responseObserver) {
		logger.info("findMoviesByGenre: data requested for "+request);
		String genre = request.getGenre();
		if(StringUtils.isEmpty(genre)) {
			String mssage = "findMoviesByGenre: invalid genre " + genre + " passed fo task";
			logger.error(mssage);
			Status status = Status.FAILED_PRECONDITION.withDescription(mssage);
			responseObserver.onError(status.asException());
			return;
		}
		
		
		List<Movie> findMovieByGenre = MoviesDBService.findMovieByGenre(genre);
		
		if(findMovieByGenre==null || findMovieByGenre.isEmpty()) {
			String mssage = "findMoviesByGenre: empty movies present for genre " + genre ;
			logger.error(mssage);
			Status status = Status.FAILED_PRECONDITION.withDescription(mssage);
			responseObserver.onError(status.asException());
			return;
		}

		responseObserver.onNext(MoviesListResponse.newBuilder().addAllMovies(findMovieByGenre).build());
		
		responseObserver.onCompleted();
	}
}
