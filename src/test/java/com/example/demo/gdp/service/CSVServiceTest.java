package com.example.demo.gdp.service;

import com.example.demo.gdp.model.Countries;
import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.model.Years;
import com.example.demo.gdp.repository.CountriesRepository;
import com.example.demo.gdp.repository.GDPReository;
import com.example.demo.gdp.repository.YearsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CSVServiceTest {
    @Mock
    private GDPReository gdprrepository;
    @Mock
    private CountriesRepository countriesRepository;
    @Mock
    private YearsRepository yearsRepository;
    @InjectMocks
    private CSVService service;

    Years year1 = new Years(1965);
    Years year2 = new Years(1970);

    Countries country1 = new Countries("ARG", "Argentina");
    Countries country2 = new Countries("AUS", "Australia");

    private List<Countries> countriesResp = Arrays.asList(new Countries[]{country1, country2});
    private List<Years> yearsResp = Arrays.asList(year1, year2);
    private List<GDPs> gdprsResp = Arrays.asList(new GDPs[]{new GDPs(country1,year1,1.5), new GDPs(country2,year2,1.8)});

    @Test
    void uploadCSV() throws IOException {
        when(countriesRepository.saveAll(any())).thenReturn(countriesResp);
        when(yearsRepository.saveAll(any())).thenReturn(yearsResp);
        when(gdprrepository.saveAll(any())).thenReturn(gdprsResp);

        FileInputStream inputFile = new FileInputStream( "src/main/resources/gdpGrowthRates.csv");
        MockMultipartFile file = new MockMultipartFile("file", "gdpGrowthRates.csv", "text/csv", inputFile);

        assertThat(service.uploadCSV(file)).matches(r -> r.getStatusCode().equals(HttpStatus.CREATED));

    }
}