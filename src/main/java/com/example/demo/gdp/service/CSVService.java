package com.example.demo.gdp.service;

import com.example.demo.gdp.CSVHelper;
import com.example.demo.gdp.model.Countries;
import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.model.ResponseMessage;
import com.example.demo.gdp.model.Years;
import com.example.demo.gdp.repository.CountriesRepository;
import com.example.demo.gdp.repository.GDPReository;
import com.example.demo.gdp.repository.YearsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CSVService {
    @Autowired
    private CountriesRepository countriesRepository;
    @Autowired
    private YearsRepository yearsRepository;
    @Autowired
    private GDPReository gdpReository;
    String message = "";
    public ResponseEntity<ResponseMessage> uploadCSV(MultipartFile file) throws IOException {
        if(CSVHelper.hasCSVFormat(file)){
            CSVParser csvParser = CSVHelper.readRecords(file.getInputStream());
            List<CSVRecord> records = csvParser.getRecords();
            List<String> headers = csvParser.getHeaderNames();
            csvParser.close();

            List<Countries> countries = CSVHelper.getCountries(records);
            List<Years> yearsArr = CSVHelper.getYears(headers);

            countriesRepository.deleteAll();
            yearsRepository.deleteAll();
            gdpReository.deleteAll();

            Iterable<Countries> savedCountriesList = countriesRepository.saveAll(countries);
            Iterable<Years> savedYearsList = yearsRepository.saveAll(yearsArr);

            List<GDPs> gdpVals = CSVHelper.getGDPs(records, savedCountriesList, savedYearsList);
            gdpReository.saveAll(gdpVals);

            message = "Uploaded successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
        }
        else{
            message = "Upload failed: " + file.getOriginalFilename();
            return  ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(new ResponseMessage(message));
        }
        //return message;
    }
}
