package com.petstore.springboot.auth;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by McStone on 2017-01-16.
 */
public interface TokenAuthenticationService {

    Authentication getAuthentication(HttpServletRequest request);
}
