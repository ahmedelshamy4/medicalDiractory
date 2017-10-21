package com.mohammed.medicaldirectoryy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mohammed.medicaldirectoryy.model.Hospitals;
import com.mohammed.medicaldirectoryy.model.HospitalsDataModel;
import com.mohammed.medicaldirectoryy.model.HostpitalsResponse;
import com.mohammed.medicaldirectoryy.model.PharmacyDataModel;
import com.mohammed.medicaldirectoryy.model.pharmacies;
import com.mohammed.medicaldirectoryy.model.PharmaciesResponse;
import com.mohammed.medicaldirectoryy.rest.ApiClientHospitals;
import com.mohammed.medicaldirectoryy.rest.ApiClientPharmacy;
import com.mohammed.medicaldirectoryy.rest.ApiInterfaceHospitals;
import com.mohammed.medicaldirectoryy.rest.ApiInterfacePharmacy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohammed on 5/4/17.
 */


public class PharmacyDetails extends AppCompatActivity implements OnMapReadyCallback {


    public static Double lat,lng;
    int numberOfBtn;
    PharmacyDataModel pharmacy;

    String nameOfPharmacy;
    String addressOfPharmacy;
    String atelephoneOfPharmacy;

    TextView pharmacy_name;
    TextView pharmacy_address;
    TextView pharmacy_telephone;

    ImageView pharmacyImage;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_details);

        numberOfBtn=getIntent().getExtras().getInt("index");

        showDialog();

        init_map();

        retrofitConnection();

    }

    private void retrofitConnection() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterfaceHospitals api=retrofit.create(ApiInterfaceHospitals.class);
        Call<PharmacyDataModel> conn=api.getPharmacies();
        conn.enqueue(new Callback<PharmacyDataModel>() {
            @Override
            public void onResponse(Call<PharmacyDataModel> call, Response<PharmacyDataModel> response) {
                Log.v("sasa",response.body().getResults().get(0).getName());
                pharmacy=response.body();

                nameOfPharmacy=pharmacy.getResults().get(numberOfBtn).getName().toString();
                addressOfPharmacy = pharmacy.getResults().get(numberOfBtn).getAddress().toString();
                atelephoneOfPharmacy=pharmacy.getResults().get(numberOfBtn).getTelephone().toString();
                // Image imgOfpharmacy = pharmacy.get(1).getImage();

                pharmacy_name= (TextView) findViewById(R.id.name_pharm_1);
                pharmacy_name.setText(nameOfPharmacy);

                pharmacy_address= (TextView) findViewById(R.id.pharmacy_address);
                pharmacy_address.setText(addressOfPharmacy);

                pharmacy_telephone= (TextView) findViewById(R.id.pharmacy_telephone);
                pharmacy_telephone.setText(atelephoneOfPharmacy);

                pharmacyImage= (ImageView) findViewById(R.id.img_pharmacy_1);
                Picasso.with(PharmacyDetails.this).load(pharmacy.getResults().get(numberOfBtn).getImages().getUrl()).into(pharmacyImage);

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<PharmacyDataModel> call, Throwable t) {
                Log.v("sasa",t.getMessage()+" ");
                progressDialog.dismiss();
                Toast.makeText(PharmacyDetails.this, "Weak Connection", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void init_map() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void showDialog() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng),20);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)));
        googleMap.animateCamera(cameraUpdate);
    }
}
