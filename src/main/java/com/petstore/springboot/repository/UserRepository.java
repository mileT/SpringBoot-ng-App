package com.petstore.springboot.repository;

import com.petstore.springboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by McStone on 2017-01-16.
 */
public interface UserRepository  extends CrudRepository<User, Integer>, Repository<User, Integer> {
    Optional<User> findOneByUsername(String username);
}
