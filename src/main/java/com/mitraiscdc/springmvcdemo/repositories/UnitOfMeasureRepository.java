package com.mitraiscdc.springmvcdemo.repositories;

import com.mitraiscdc.springmvcdemo.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String uom);
}
