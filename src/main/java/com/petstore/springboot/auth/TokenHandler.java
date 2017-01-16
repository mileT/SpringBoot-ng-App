package com.petstore.springboot.auth;

import com.petstore.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by McStone on 2017-01-16.
 */
@Component
public interface TokenHandler {

    Optional<UserDetails> parseUserFromToken(String token);

    String createTokenForUser(User user);
}
