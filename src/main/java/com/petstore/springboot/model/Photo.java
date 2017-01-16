package com.petstore.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by McStone on 2017-01-15.
 */
@Entity
public class Photo implements Serializable{

    private static final long serialVersionUID = -8062728229913766657L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "petId", nullable = false)
    private Pet pet;

    private String url;

    public Photo() {
        super();
    }

    public Photo(Integer id, Pet pet, String url) {
        super();
        this.id = id;
        this.pet = pet;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + ((id == null)? 0 : id.hashCode());
        result = prime*result + ((pet == null)? 0 : pet.hashCode());
        result = prime*result + ((url == null)? 0 : url.hashCode());
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
        Photo other = (Photo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (pet == null) {
            if (other.pet != null)
                return false;
        } else if (!pet.equals(other.pet))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }
}
