package com.petstore.springboot.controller;

import com.petstore.springboot.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by McStone on 2017-01-15.
 */
public class JsonPetConverter {


    // convert from Entity pet to json pet
    public  JsonPet fromEntity(Pet pet) {
        JsonPet jsonPet = new JsonPet();
        jsonPet.setName(pet.getName());
        jsonPet.setId(pet.getId());
        jsonPet.setStatus(pet.getStatus()!=null? pet.getStatus().toString().toLowerCase(): null);
        jsonPet.setCategory(getJsonCategory(pet.getCategory()));
        jsonPet.setPhotoUrls(getJsonPhoto(pet.getPhotoUrls()));
        jsonPet.setTags(getJsonTags(pet.getTags()));

        return jsonPet;
    }

    // convet from Entity pet list to json pet list
    public Collection<JsonPet> fromEntityList(Collection<Pet> pets){
        Collection<JsonPet> jsonPets = new ArrayList<>();
        for (Pet pet: pets){
            jsonPets.add(fromEntity(pet));
        }
        return jsonPets;
    }

    public Pet fromJson(JsonPet jsonPet){
        Pet pet = new Pet();
        pet.setId(jsonPet.getId());
        pet.setName(jsonPet.getName());
        pet.setStatus(jsonPet.getStatus()!=null? Status.valueOf(jsonPet.getStatus().toUpperCase()):null);
        pet.setPhotoUrls(buildPhoto(jsonPet.getPhotoUrls(),pet));
        pet.setTags(buildTags(jsonPet.getTags(),pet));

        return pet;
    }

    // convert from Entity tags to json tags
    private Set<JsonTag> getJsonTags(Set<Tag> tags) {
        Set<JsonTag> jsonTags = new HashSet<>();
        for (Tag tag: tags) {
            JsonTag jsonTag = new JsonTag();
            jsonTag.setId(tag.getId());
            jsonTag.setName(tag.getName());
            jsonTags.add(jsonTag);
        }
        return jsonTags;
    }
    // convert from Entity category to json categary
    private JsonCategory getJsonCategory(Category category) {
        JsonCategory jsonCategory = new JsonCategory();
        jsonCategory.setId(category.getId());
        jsonCategory.setName(category.getName());
        return jsonCategory;
    }
    // convert from Entity photoUrls to set<string>
    private Set<String> getJsonPhoto(Set<Photo> photoUrls) {
        HashSet<String> jsonPhoto = new HashSet<>();
        for (Photo photo: photoUrls){
            jsonPhoto.add(photo.getUrl());
        }
        return jsonPhoto;
    }
    // get model photo urls from json
    private Set<Photo> buildPhoto(Set<String> photoUrls, Pet pet) {
        if(photoUrls==null || photoUrls.isEmpty()){
            return null;
        }
        Set<Photo> photoSet = new HashSet<>();
        for(String photoString: photoUrls) {
            Photo photo = new Photo();
            photo.setUrl(photoString);
            photo.setPet(pet);
            photoSet.add(photo);
        }
        return photoSet;
    }
    // get model category from json
    private Category buildCategory(JsonCategory jsonCategory) {
        if(jsonCategory == null) {
            return null;
        }
        Category category = new Category();
        category.setId(jsonCategory.getId());
        category.setName(jsonCategory.getName());
        return category;
    }

    private Set<Tag> buildTags(Set<JsonTag> jsonTags, Pet pet) {
        if (jsonTags==null || jsonTags.isEmpty()){
            return null;
        }
        Set<Tag> tags = new HashSet<>();
        for (JsonTag jsonTag: jsonTags) {
            Tag tag = new Tag();
            tag.setId(jsonTag.getId());
            tag.setName(jsonTag.getName());
            Set<Pet> pets = new HashSet<>();
            pets.add(pet);
            tag.setPets(pets);
            tags.add(tag);
        }
        return tags;
    }

}
