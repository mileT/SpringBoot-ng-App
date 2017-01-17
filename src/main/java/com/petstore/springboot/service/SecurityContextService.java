package com.petstore.springboot.service;

import com.petstore.springboot.model.User;

import java.util.Optional;

/**
 * Created by jhan on 1/16/2017.
 */
public interface SecurityContextService {
    Optional<User> currentUser();
}
