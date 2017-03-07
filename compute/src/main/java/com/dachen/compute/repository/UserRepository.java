package com.dachen.compute.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dachen.compute.domain.User;

public interface UserRepository extends MongoRepository<User, Long> {

	User findByName(String name);
}
