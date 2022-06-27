package com.example.demo.gdp.repository;

import com.example.demo.gdp.model.GDPs;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GDPReository extends JpaRepository<GDPs, Integer>{
    List<GDPs> findByCountries_CodeAndYears_YearGreaterThanEqualAndYears_YearLessThanEqual(String Code, int year, int year1);
    //List<GDPs> findByCountry_CodeAndYear_YearGreaterThanEqualAndYear_YearLessThanEqual(String Code, int year, int year1);


}
