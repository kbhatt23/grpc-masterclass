package com.learning.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.user_service.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{

}
