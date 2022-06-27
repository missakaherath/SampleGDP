package com.example.demo.gdp;

import com.example.demo.gdp.model.Countries;
import com.example.demo.gdp.model.GDPs;
import com.example.demo.gdp.model.Years;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Country Name", "Country Code"};

    public static boolean hasCSVFormat(MultipartFile file){
        if(!TYPE.equals(file.getContentType())){
            return false;
        }
        return true;
    }

    public static CSVParser readRecords(InputStream is) throws IOException {
        try{
           BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
           CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        return csvParser;}
        catch(IOException e){
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Countries> getCountries(List<CSVRecord> csvRecords){
        List<Countries> countries = new ArrayList<>();
        for (CSVRecord csvRecord:
             csvRecords) {
            countries.add(new Countries(csvRecord.get(1), csvRecord.get(0)));
        }
        return countries;
    }

    public static List<Years> getYears(List<String> years) {
        List<Years> yearsArray = new ArrayList<>();
        for (String year :
                years) {
            try {
                yearsArray.add(new Years(Integer.parseInt(year)));
            } catch (NumberFormatException ignore) {
            }

        }
        return yearsArray;
    }

    public static List<GDPs> getGDPs(List<CSVRecord> records, Iterable<Countries> savedCountriesList, Iterable<Years> savedYearsList){
        List<GDPs> gdpVals = new ArrayList<>();
        Map<String, Countries> countriesMap = new HashMap<>();

        savedCountriesList.forEach(savedCountry -> {
            countriesMap.put(savedCountry.getCode(), savedCountry);
        });

        for(CSVRecord record:records){
            Countries country = countriesMap.get(record.get(HEADERs[1]));

            savedYearsList.forEach(year -> {
                try{
                    double gdpVal = Double.parseDouble(record.get(String.valueOf(year.getYear())));
                } catch (NullPointerException | NumberFormatException ignore){}
            });
        }
        return gdpVals;

    }



}
