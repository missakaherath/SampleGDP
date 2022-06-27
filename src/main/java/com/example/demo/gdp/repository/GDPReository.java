package com.example.demo.gdp.repository;

import com.example.demo.gdp.model.GDPs;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GDPReository extends JpaRepository<GDPs, Integer>{

}
