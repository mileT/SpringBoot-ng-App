package com.petstore.springboot.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by McStone on 2017-01-15.
 */
public class JsonCategory {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private Integer id;

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
}
