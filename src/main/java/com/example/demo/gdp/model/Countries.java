package com.example.demo.gdp.model;

import javax.persistence.*;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;

    private String code;

    private String name;

    public Countries(String Code, String Name) {
        //this.setCountryId(countryId);
        this.setCode(Code);
        this.setName(Name);
    }

    public Countries() {

    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCode(String Code) {
        this.code = Code;
    }


    public int getCountryId() {
        return countryId;
    }

    public String getCode() {
        return code;
    }

    public String toString(){
        return "Country{" +
                "countryId=" + countryId +
                ", Code='" + code + "'" +
                '}';
    }
}
