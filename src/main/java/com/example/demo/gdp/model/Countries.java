package com.example.demo.gdp.model;

import org.springframework.core.SpringVersion;

import javax.persistence.*;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;

    private String Code;

    private String Name;

    public Countries(String Code, String Name) {
        //this.setCountryId(countryId);
        this.setCode(Code);
        this.setName(Name);
    }

    public Countries() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }


    public int getCountryId() {
        return countryId;
    }

    public String getCode() {
        return Code;
    }

    public String toString(){
        return "Country{" +
                "countryId=" + countryId +
                ", Code='" + Code + "'" +
                '}';
    }
}
