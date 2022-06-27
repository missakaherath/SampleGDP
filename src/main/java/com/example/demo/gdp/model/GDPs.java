package com.example.demo.gdp.model;

import javax.persistence.*;

@Entity
public class GDPs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer GdpId;

    @ManyToOne
    private Countries countries;

    @ManyToOne
    private Years years;
    private double gdp;


    public GDPs() {
    }

    public GDPs(Countries country, Years year, double gdp) {
        this.setCountry(country);
        this.setYear(year);
        this.setGdp(gdp);
    }



    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public Countries getCountry() {
        return countries;
    }

    public void setCountry(Countries country) {
        this.countries = country;
    }

    public Years getYear() {
        return years;
    }

    public void setYear(Years year) {
        this.years = year;
    }

    public double getGdp() {
        return gdp;
    }

    public String toString(){
        return "GDP{" +
                "CountryId=" + countries +
                ", yearId='" + years + "'" +
                ", gdp='" + gdp + "'" +
                '}';
    }

}
