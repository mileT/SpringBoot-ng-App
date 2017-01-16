package com.petstore.springboot.service;

import com.petstore.springboot.model.Pet;

import java.util.Collection;

/**
 * Created by McStone on 2017-01-15.
 */
public interface PetService {
    void save(Pet pet);
    void deleteById(Integer id);
    Pet findByName(String name);
    Pet findById(Integer id);
    Collection<Pet> findAll();

}
