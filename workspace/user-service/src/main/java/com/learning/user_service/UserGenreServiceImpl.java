package com.learning.user_service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learning.user_service.entities.UserEntity;
import com.learning.user_service.models.UserGenreMessageRequest;
import com.learning.user_service.models.UserGenreMessageResponse;
import com.learning.user_service.models.UserGenreServiceGrpc.UserGenreServiceImplBase;
import com.learning.user_service.repositories.UserEntityRepository;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserGenreServiceImpl extends UserGenreServiceImplBase {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserEntityRepository repository;

	@Override
	public void favouriteGenre(UserGenreMessageRequest request,
			StreamObserver<UserGenreMessageResponse> responseObserver) {
		logger.info("favouriteGenre: finding favourite genre for request " + request);

		int userId = request.getUserId();
		// default is 0 if not passed

		if (userId <= 0) {
			String mssage = "favouriteGenre: invalid userid " + userId + " passed fo task";
			logger.error(mssage);
			Status status = Status.FAILED_PRECONDITION.withDescription(mssage);
			responseObserver.onError(status.asException());
			return;
		}
		
		Optional<UserEntity> findById = repository.findById(userId);
		if(findById.isPresent()) {
			UserEntity userEntity = findById.get();
			responseObserver.onNext(UserGenreMessageResponse.newBuilder().setFavouriteGenre(userEntity.getFavouriteGenre())
					.setUserId(userId).build()
					);
			responseObserver.onCompleted();
			
		}else {
			String mssage = "favouriteGenre: user " + userId + " do not exists in D.B";
			logger.error(mssage);
			Status status = Status.FAILED_PRECONDITION.withDescription(mssage);
			responseObserver.onError(status.asException());
		}

	}
}
