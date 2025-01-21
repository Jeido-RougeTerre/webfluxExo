package com.jeido.webfluxexo.ex7.repository;

import com.jeido.webfluxexo.ex7.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
