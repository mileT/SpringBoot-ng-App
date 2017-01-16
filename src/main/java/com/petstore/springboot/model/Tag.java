package com.petstore.springboot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by McStone on 2017-01-15.
 */
@Entity
public class Tag implements Serializable{

    private static final long serialVersionUID = 2441654998943550978L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    private Set<Pet> pets;

    public Tag() {
        super();
    }

    public Tag(Integer id, String name, Set<Pet> pets) {
        super();
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public Tag(Integer id, String name, Pet pet) {
        super();
        this.id = id;
        this.name = name;
        Set<Pet> pets = new HashSet<>();
        pets.add(pet);
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pets == null) ? 0 : pets.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tag other = (Tag) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pets == null) {
            if (other.pets != null)
                return false;
        } else if (!pets.equals(other.pets))
            return false;
        return true;
    }

}
