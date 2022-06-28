package com.example.demo.gdp.controller;

import com.example.demo.gdp.service.gdpService;
import com.example.demo.gdp.model.GDPresponse;
import com.example.demo.gdp.model.GDPs;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/gdp")
public class gdpController {

    private gdpService gdpservice;
    private List<GDPresponse> gdpResponses = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(CSVController.class);

    @Autowired
    public gdpController(gdpService gdpservice) {
       this.gdpservice = gdpservice;
    }

    @GetMapping
    public List<GDPresponse> getGdpValuesByYear(@RequestParam("country") String code, @RequestParam("from") String from, @RequestParam("to") String to, HttpServletRequest request){
        String loggerMsg = String.format("GET request received to gdpController from %s",request.getRemoteAddr());
        logger.info(loggerMsg);
        return gdpservice.getGDPs(code, from, to);
    }
}
