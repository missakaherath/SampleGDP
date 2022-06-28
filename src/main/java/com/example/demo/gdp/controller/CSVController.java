package com.example.demo.gdp.controller;

import com.example.demo.gdp.model.ResponseMessage;
import com.example.demo.gdp.repository.CountriesRepository;
import com.example.demo.gdp.repository.GDPReository;
import com.example.demo.gdp.repository.YearsRepository;
import com.example.demo.gdp.service.CSVService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/csv")
//@RequiredArgsConstructor
public class CSVController {

    private CSVService csvService;

    Logger logger = LoggerFactory.getLogger(CSVController.class);

    @Autowired
    public CSVController(CSVService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {

        String loggerMsg = String.format("POST request received to CSVController from %s",request.getRemoteAddr());
        logger.info(loggerMsg);
        return csvService.uploadCSV(file);

}}
