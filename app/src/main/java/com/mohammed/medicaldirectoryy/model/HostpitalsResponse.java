package com.mohammed.medicaldirectoryy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 */

public class HostpitalsResponse {
    @SerializedName("results")
    private List<Hospitals> results;
    public List<Hospitals> getResults() {
        return results;
    }

    public void setResults(List<Hospitals> results) {
        this.results = results;
    }
}
