package com.example.demo.gdp;

import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.repository.GDPReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class gdpService {

    private final GDPReository gdpReository;

    @Autowired
    public gdpService(GDPReository gdpReository) {
        this.gdpReository = gdpReository;
    }

    public List<GDPs> getGDPs(){
        return gdpReository.findAll();
    }

}
