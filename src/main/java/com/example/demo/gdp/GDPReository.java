package com.example.demo.gdp;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface GDPReository extends JpaRepository<GDPs, Integer>{

}
