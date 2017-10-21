package com.mohammed.medicaldirectoryy.rest;



import com.mohammed.medicaldirectoryy.model.PharmaciesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfacePharmacy {
    @GET("11ikh9")
    Call<PharmaciesResponse> getPharmacyNumber();
    @GET("11ikh9")
    Call<PharmaciesResponse>getName();



}
