package com.mitraiscdc.springmvcdemo.repositories;

import com.mitraiscdc.springmvcdemo.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
