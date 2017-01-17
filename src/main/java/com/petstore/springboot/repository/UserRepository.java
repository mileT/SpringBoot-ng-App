package com.petstore.springboot.repository;

import com.petstore.springboot.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by McStone on 2017-01-16.
 */
public interface UserRepository  extends CrudRepository<User, Integer>, Repository<User, Integer> {

    User findByName(String name);
    User findById(Integer id);
    Collection<User> findAll(Sort sort);
    Optional<User> findOneByUsername(String username);
}
