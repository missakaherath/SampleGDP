package com.example.demo.gdp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GDPs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer CountryId;
    private Integer yearId;
    private double gdp;


    public GDPs() {
    }

    public GDPs(Integer CountryId, Integer yearId, double gdp) {
        this.setCountryId(CountryId);
        this.setYearId(yearId);
        this.setGdp(gdp);
    }

    public void setCountryId(Integer countryId) {
        CountryId = countryId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public Integer getCountryId() {
        return CountryId;
    }

    public Integer getYearId() {
        return yearId;
    }

    public double getGdp() {
        return gdp;
    }

    public String toString(){
        return "GDP{" +
                "CountryId=" + CountryId +
                ", yearId='" + yearId + "'" +
                ", gdp='" + gdp + "'" +
                '}';
    }

}
