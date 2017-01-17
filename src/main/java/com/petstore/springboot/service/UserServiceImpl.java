package com.petstore.springboot.service;

import com.petstore.springboot.model.User;
import com.petstore.springboot.repository.PetRepository;
import com.petstore.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by jhan on 1/16/2017.
 */
@Service("userSerice")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final SecurityContextService securityContextService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PetRepository petRepository,
                           SecurityContextService securityContextService) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.securityContextService = securityContextService;
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteById(Integer id) {
        userRepository.delete(id);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<User> findAll() {
        return (Collection<User>) userRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Optional<User> user = Optional.ofNullable(userRepository.findByName(s));
        final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
        user.ifPresent(detailsChecker::check);
        return user.orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
