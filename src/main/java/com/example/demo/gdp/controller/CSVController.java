package com.example.demo.gdp.controller;

import com.example.demo.gdp.CSVHelper;
import com.example.demo.gdp.model.Countries;
import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.model.ResponseMessage;
import com.example.demo.gdp.model.Years;
import com.example.demo.gdp.repository.CountriesRepository;
import com.example.demo.gdp.repository.GDPReository;
import com.example.demo.gdp.repository.YearsRepository;
import com.example.demo.gdp.service.CSVService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/csv")
//@RequiredArgsConstructor
public class CSVController {
    @Autowired
    private CountriesRepository countriesRepository;
    @Autowired
    private YearsRepository yearsRepository;
    @Autowired
    private GDPReository gdpReository;

    private CSVService csvService;
    String message = "";

    @Autowired
    public CSVController(CSVService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {

        return csvService.uploadCSV(file);

//        if(CSVHelper.hasCSVFormat(file)){
//            CSVParser csvParser = CSVHelper.readRecords(file.getInputStream());
//            List<CSVRecord> records = csvParser.getRecords();
//            List<String> headers = csvParser.getHeaderNames();
//            csvParser.close();
//
//            List<Countries> countries = CSVHelper.getCountries(records);
//            List<Years> yearsArr = CSVHelper.getYears(headers);
//
//            countriesRepository.deleteAll();
//            yearsRepository.deleteAll();
//            gdpReository.deleteAll();
//
//            Iterable<Countries> savedCountriesList = countriesRepository.saveAll(countries);
//            Iterable<Years> savedYearsList = yearsRepository.saveAll(yearsArr);
//
//            List<GDPs> gdpVals = CSVHelper.getGDPs(records, savedCountriesList, savedYearsList);
//            gdpReository.saveAll(gdpVals);
//
//            message = "Uploaded successfully: " + file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
//    }
//        else{
//            message = "Upload failed: " + file.getOriginalFilename();
//            return  ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(new ResponseMessage(message));
//        }
}}
