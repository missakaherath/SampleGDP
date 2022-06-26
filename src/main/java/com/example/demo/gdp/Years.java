package com.example.demo.gdp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Years {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int yearId;
    private int year;

    public Years(int yearId, int year) {
        this.setYearId(yearId);
        this.setYear(year);
    }

    public Years() {

    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        return "Year{" +
                "yearId=" + yearId +
                ", year='" + year + "'" +
                '}';
    }
}
