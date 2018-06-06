package com.mitraiscdc.springmvcdemo.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getDescription() {
        String descriptionValue = "Category 1";
        category.setDescription(descriptionValue);

        assertThat(descriptionValue).isEqualTo(category.getDescription());
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void getRecipes() {
    }

    @Test
    public void setRecipes() {
    }
}