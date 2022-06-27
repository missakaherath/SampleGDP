package com.example.demo.gdp.model;

public class GDPresponse {
    private int year;
    private double gdp;

    public GDPresponse(int year, double gdp) {
        this.year = year;
        this.gdp = gdp;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }
}
