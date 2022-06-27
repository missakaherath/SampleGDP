package com.example.demo.gdp.model;

import javax.persistence.*;

@Entity
public class GDPs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer GdpId;

    @ManyToOne
    private Countries country;

    @ManyToOne
    private Years year;
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
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Years getYear() {
        return year;
    }

    public void setYear(Years year) {
        this.year = year;
    }

    public double getGdp() {
        return gdp;
    }

    public String toString(){
        return "GDP{" +
                "CountryId=" + country +
                ", yearId='" + year + "'" +
                ", gdp='" + gdp + "'" +
                '}';
    }

}
