package com.mohammed.medicaldirectoryy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PharmaciesResponse {

    @SerializedName("results")
    private List<pharmacies>results;
    @SerializedName("name")
    private List<pharmacies> name ;

    public List<pharmacies> getResults() {
        return results;
    }

    public void setResults(List<pharmacies> results) {
        this.results = results ;
    }

    public List<pharmacies> getName() {
        return name;
    }

    public void setName(List<pharmacies> name) {
        this.name = name;
    }
}