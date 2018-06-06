package com.mitraiscdc.springmvcdemo.domain;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Notes extends BaseEntity {

    @OneToOne
    private Recipe recipe;

    @Lob
    private String notes;

    public Notes() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
