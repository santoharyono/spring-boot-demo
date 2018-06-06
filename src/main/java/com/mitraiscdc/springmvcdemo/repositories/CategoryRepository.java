package com.mitraiscdc.springmvcdemo.repositories;

import com.mitraiscdc.springmvcdemo.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
