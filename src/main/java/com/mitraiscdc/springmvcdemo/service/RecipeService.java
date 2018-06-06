package com.mitraiscdc.springmvcdemo.service;

import com.mitraiscdc.springmvcdemo.domain.Recipe;
import com.mitraiscdc.springmvcdemo.repositories.RecipeRepository;
import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe() {
        List<Recipe> result = new ArrayList<>();
        recipeRepository.findAll().iterator().forEachRemaining(result::add);

        return result;
    }

    public Optional<Recipe> getRecipeById(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if (!optionalRecipe.isPresent())
            throw new RuntimeException("Expected recipe not found");

        return optionalRecipe;
    }

    public void createRecipe(Recipe recipe) {
        try {
            recipeRepository.save(recipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
