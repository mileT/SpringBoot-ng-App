package com.petstore.springboot.controller;

import com.petstore.springboot.model.Pet;
import com.petstore.springboot.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by McStone on 2017-01-15.
 */

@RestController
public class PetController {

    @Autowired
    private PetService petService;

    /*
        Find all pets
    */
    @RequestMapping(value = "/pet/", method= RequestMethod.GET)
    @ResponseBody
    public Collection<JsonPet> findAll() {
        Collection<Pet> pets = petService.findAll();
        Collection<JsonPet> jsonPets = new JsonPetConverter().fromEntityList(pets);
        return jsonPets;
    }

    /*
        Get one pet from database
    */
    @Transactional(propagation = Propagation.SUPPORTS)
    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonPet find(@PathVariable("id") final Integer id) {
        Pet pet = petService.findById(id);
        JsonPet jsonPet = new JsonPetConverter().fromEntity(pet);
        return jsonPet;
    }

    /*
        Save pet to the database
    */
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/pet", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody JsonPet save(@RequestBody final JsonPet jsonPet){
        Pet pet = new JsonPetConverter().fromJson(jsonPet);
        petService.save(pet);
        JsonPet createdJsonPet = new JsonPetConverter().fromEntity(pet);
        return createdJsonPet;
    }

}
