package com.example.demo.gdp.service;

import com.example.demo.gdp.model.Countries;
import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.model.Years;
import com.example.demo.gdp.repository.GDPReository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class gdpServiceTest {
    @Mock
    private GDPReository repository;
    @InjectMocks
    private gdpService service;


    @Test
    void getGDPs() {
        String code = "AFW";
        int from = 1965;
        int to = 1970;

        Countries country = new Countries("AFW", "Africa Western and Central");
        Years year2 = new Years(1966);
        Years year1 = new Years(1967);

        when(repository.findByCountries_CodeAndYears_YearGreaterThanEqualAndYears_YearLessThanEqual(code, from, to)).thenReturn(Stream
                .of(new GDPs[]{new GDPs(country, year1, 1.5), new GDPs(country, year2, 1.8)}).collect(Collectors.toList()));

        assertEquals(2, service.getGDPs("AFW", "1965", "1970").size());
    }
}