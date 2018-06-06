package com.mitraiscdc.springmvcdemo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
