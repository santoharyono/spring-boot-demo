package com.mitraiscdc.springmvcdemo.service;

import com.mitraiscdc.springmvcdemo.domain.Recipe;
import com.mitraiscdc.springmvcdemo.repositories.RecipeRepository;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @Test
    public void getAllRecipe() {
        // stubbing
        Recipe recipe = new Recipe();
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipes);

        List<Recipe> allRecipe = recipeService.getAllRecipe();

        assertThat(allRecipe).hasSize(1);

        // verify
        verify(recipeRepository).findAll();
    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(recipeRepository);
    }
}