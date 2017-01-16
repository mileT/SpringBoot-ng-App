package com.petstore.springboot.auth;

import com.petstore.springboot.model.User;
import com.petstore.springboot.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Created by McStone on 2017-01-16.
 */
@Component
public class TokenHandlerImpl implements TokenHandler{
    private final String secret;
    private final UserRepository userRepository;

    @Autowired
    public TokenHandlerImpl(@Value("${app.jwt.secrect") String secret, UserRepository userRepository) {
        this.secret = secret;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDetails> parseUserFromToken(String token) {
        final String subject = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        final Integer userId = Integer.valueOf(subject);
        final User user = userRepository.findOne(userId);

        return Optional.ofNullable(user);
    }

    @Override
    public String createTokenForUser(User user) {
        final ZonedDateTime afterOneweek = ZonedDateTime.now().plusWeeks(1);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneweek.toInstant()))
                .compact();
    }
}

