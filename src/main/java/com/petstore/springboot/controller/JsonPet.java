package com.petstore.springboot.controller;


import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by McStone on 2017-01-15.
 */
public class JsonPet {

    @NotNull
    private Set<String> photoUrls;

    @NotNull
    private String name;

    private Integer id;

    private JsonCategory category;

    private Set<JsonTag> tags;

    private String status;

    public Set<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(Set<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JsonCategory getCategory() {
        return category;
    }

    public void setCategory(JsonCategory category) {
        this.category = category;
    }

    public Set<JsonTag> getTags() {
        return tags;
    }

    public void setTags(Set<JsonTag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
