package com.petstore.springboot.service;

import com.petstore.springboot.model.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by jhan on 1/16/2017.
 */
public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {
    void save(User user);
    void deleteById(Integer id);
    User findByName(String name);
    User findById(Integer id);
    Collection<User> findAll();
}
