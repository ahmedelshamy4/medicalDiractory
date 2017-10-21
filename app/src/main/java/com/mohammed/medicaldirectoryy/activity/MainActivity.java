package com.mohammed.medicaldirectoryy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mohammed.medicaldirectoryy.R;
import com.mohammed.medicaldirectoryy.model.PharmaciesResponse;
import com.mohammed.medicaldirectoryy.model.pharmacies;
import com.mohammed.medicaldirectoryy.rest.ApiClientPharmacy;
import com.mohammed.medicaldirectoryy.rest.ApiInterfacePharmacy;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterfacePharmacy apiService =
                ApiClientPharmacy.getClient().create(ApiInterfacePharmacy.class);

        retrofit2.Call<PharmaciesResponse> call = apiService.getPharmacyNumber();
        call.enqueue(new Callback<PharmaciesResponse>() {
            @Override
            public void onResponse(retrofit2.Call<PharmaciesResponse> call, Response<PharmaciesResponse> response) {
                List<pharmacies> pharmacies = response.body().getResults();
                Toast.makeText(MainActivity.this, "Number is : " + pharmacies.size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(retrofit2.Call<PharmaciesResponse> call, Throwable t) {

            }
        });
    }
}
