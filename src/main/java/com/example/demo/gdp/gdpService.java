package com.example.demo.gdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
