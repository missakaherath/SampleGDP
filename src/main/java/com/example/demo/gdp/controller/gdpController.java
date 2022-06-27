package com.example.demo.gdp.controller;

import com.example.demo.gdp.gdpService;
import com.example.demo.gdp.model.GDPs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/gdp")
public class gdpController {

    private final gdpService gdpservice;

    @Autowired
    public gdpController(gdpService gdpservice) {
       this.gdpservice = gdpservice;
    }

    @GetMapping
    public List<GDPs> getGdp(){
        return gdpservice.getGDPs();
    }
}
