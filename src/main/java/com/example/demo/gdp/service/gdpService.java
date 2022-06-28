package com.example.demo.gdp.service;

import com.example.demo.gdp.model.GDPresponse;
import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.repository.GDPReository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class gdpService {

    private final GDPReository gdpReository;

    public List<GDPs> getGDPs(){
        return gdpReository.findAll();
    }

    public List<GDPresponse> getGDPs(String Code, String from, String to){
        List<GDPs> GDPvalues = gdpReository.findByCountries_CodeAndYears_YearGreaterThanEqualAndYears_YearLessThanEqual(Code, Integer.parseInt(from), Integer.parseInt(to));
        List<GDPresponse> GDPresponses = new ArrayList<>();
        for (GDPs gdpObj:
             GDPvalues) {
            GDPresponses.add(new GDPresponse(gdpObj.getYear().getYear(), gdpObj.getGdp()));
        }
        return GDPresponses;
    }
}
