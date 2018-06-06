package com.mitraiscdc.springmvcdemo.repositories;

import com.mitraiscdc.springmvcdemo.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
