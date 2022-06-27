package com.example.demo.gdp.controller;

import com.example.demo.gdp.service.gdpService;
import com.example.demo.gdp.model.GDPresponse;
import com.example.demo.gdp.model.GDPs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/gdp")
public class gdpController {

    private gdpService gdpservice;
    private List<GDPresponse> gdpResponses = new ArrayList<>();

    @Autowired
    public gdpController(gdpService gdpservice) {
       this.gdpservice = gdpservice;
    }

//    @GetMapping()
//    public List<GDPs> getGdp(){
//        return gdpservice.getGDPs();
//    }

    @GetMapping
    public List<GDPresponse> getGdpValuesByYear(@RequestParam("country") String code, @RequestParam("from") String from, @RequestParam("to") String to){
        return gdpservice.getGDPs(code, from, to);
    }
}
