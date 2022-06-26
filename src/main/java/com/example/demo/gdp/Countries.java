package com.example.demo.gdp;

import org.springframework.core.SpringVersion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    private String countrCode;

    public Countries(int countryId, String countrCode) {
        this.setCountryId(countryId);
        this.setCountrCode(countrCode);
    }

    public Countries() {

    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCountrCode(String countrCode) {
        this.countrCode = countrCode;
    }


    public int getCountryId() {
        return countryId;
    }

    public String getCountrCode() {
        return countrCode;
    }

    public String toString(){
        return "Country{" +
                "countryId=" + countryId +
                ", countrCode='" + countrCode + "'" +
                '}';
    }
}
