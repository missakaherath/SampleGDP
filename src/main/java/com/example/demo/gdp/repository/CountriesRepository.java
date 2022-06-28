package com.example.demo.gdp.repository;

import com.example.demo.gdp.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepository extends CrudRepository<Countries, Integer> {
}
