package com.example.demo.gdp.repository;

import com.example.demo.gdp.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, Integer> {
}
