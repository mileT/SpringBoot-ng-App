package com.petstore.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by McStone on 2017-01-15.
 */
@Entity
public class Pet implements Serializable{


    private static final long serialVersionUID = -6997968194548926410L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @Size(max=255)
    private String name;

    @OneToMany(mappedBy = "pet", orphanRemoval = true, cascade = CascadeType.ALL)
    @NotNull
    private Set<Photo> photoUrls;

    @OneToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @ManyToMany(mappedBy = "pets", cascade = CascadeType.REMOVE)
    private Set<Tag> tags;

    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Set<Photo> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(Set<Photo> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
