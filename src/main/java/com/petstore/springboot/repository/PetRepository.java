package com.petstore.springboot.repository;

import com.petstore.springboot.model.Pet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;

/**
 * Created by McStone on 2017-01-15.
 */

public interface PetRepository extends CrudRepository<Pet, Integer>, Repository<Pet, Integer> {

    Pet findByName(String name);

    Pet findById(Integer id);

    Collection<Pet> findAll(Sort sort);

}
