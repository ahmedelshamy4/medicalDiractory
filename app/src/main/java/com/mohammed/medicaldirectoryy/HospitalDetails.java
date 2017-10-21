package com.mohammed.medicaldirectoryy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.mohammed.medicaldirectoryy.rest.ApiClientHospitals;
import com.mohammed.medicaldirectoryy.rest.ApiInterfaceHospitals;
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

public class HospitalDetails extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    GoogleMap googleMap;
    ProgressDialog progressBar;
    ArrayList<Hospitals> hospital;

    String nameOfHospital;
    String addressOfHospital;
    String telephoneOfHospital;

    TextView hospital_name;
    TextView hospital_address;
    TextView hospital_telephone;
    Toolbar toolbar;
    ImageView fav;
    int numberOfBtn;
    boolean flag=true;
    SharedPreferences sharedPreferences;
    public static Double lat,lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        toolbar= (Toolbar) findViewById(R.id.maintoolbar);
        toolbar.setTitle("Hospital Details");
        setSupportActionBar(toolbar);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        progressBar = new ProgressDialog(this);
        progressBar.setMessage("Loading");
        progressBar.setCancelable(false);
        progressBar.show();

        fav = (ImageView) findViewById(R.id.fav);
        fav.setOnClickListener(this);


        Intent intent = getIntent();
         numberOfBtn = intent.getExtras().getInt("index");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterfaceHospitals api=retrofit.create(ApiInterfaceHospitals.class);

        Call<HospitalsDataModel> conn = api.getHospitals();
        conn.enqueue(new Callback<HospitalsDataModel>() {
            @Override
            public void onResponse(Call<HospitalsDataModel> call, Response<HospitalsDataModel> response) {
                nameOfHospital = response.body().getResults().get(numberOfBtn).getName().toString();
                addressOfHospital = response.body().getResults().get(numberOfBtn).getAddress().toString();
                telephoneOfHospital = response.body().getResults().get(numberOfBtn).getTelephone().toString();
                // Image imgOfHospital = hospital.get(1).getImage();


                hospital_name = (TextView) findViewById(R.id.name_hos_1);
                hospital_name.setText(nameOfHospital);

                hospital_address = (TextView) findViewById(R.id.hospital_address);
                hospital_address.setText(addressOfHospital);

                hospital_telephone = (TextView) findViewById(R.id.hospital_telephone);
                hospital_telephone.setText(telephoneOfHospital);
                ImageView imageView= (ImageView) findViewById(R.id.img_hospital_1);
                Picasso.with(HospitalDetails.this).load(response.body().getResults().get(numberOfBtn).getImage().getUrl()).into(imageView);

                progressBar.dismiss();
            }

            @Override
            public void onFailure(Call<HospitalsDataModel> call, Throwable t) {
                Log.v("ddd",t.getMessage()+">>");

            }
        });


    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng),20);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)));
        googleMap.animateCamera(cameraUpdate);
    }

    @Override
    public void onClick(View v) {

        if(flag){
            sharedPreferences.edit().putInt("id",numberOfBtn).commit();
            fav.setImageResource(android.R.drawable.star_big_on);
            Toast.makeText(this, "marked as favourit", Toast.LENGTH_SHORT).show();
            flag=false;
        }else{
            sharedPreferences.edit().remove("id");
            fav.setImageResource(android.R.drawable.star_big_off);
            Toast.makeText(this, "remove from favourit", Toast.LENGTH_SHORT).show();
            flag=true;
        }
    }
}
