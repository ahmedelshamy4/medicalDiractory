package com.mohammed.medicaldirectoryy.rest;

import com.mohammed.medicaldirectoryy.model.HospitalsDataModel;
import com.mohammed.medicaldirectoryy.model.HostpitalsResponse;
import com.mohammed.medicaldirectoryy.model.PharmacyDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abdallah on 04/05/17.
 */

public interface ApiInterfaceHospitals {

    @GET("xozjp")
    Call<HostpitalsResponse> getHospitalNumber();
    @GET("xozjp")
    Call<HostpitalsResponse>getName();


    @GET("bins/7nvl9")
    Call<HospitalsDataModel> getHospitals();

    @GET("bins/aaed9")
    Call<PharmacyDataModel> getPharmacies();
}
