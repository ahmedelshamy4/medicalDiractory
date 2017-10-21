package com.mohammed.medicaldirectoryy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohammed.medicaldirectoryy.adapters.HospitalRecyclerAdapter;
import com.mohammed.medicaldirectoryy.model.HospitalsDataModel;
import com.mohammed.medicaldirectoryy.rest.ApiInterfaceHospitals;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavouriteFragment extends Fragment {

    RecyclerView favRecycler;
    public static final String ARG_PAGE = "ARG_PAGE";
    HospitalsDataModel.ResultsBean finalL;
    List<HospitalsDataModel> finaList;
    SharedPreferences sharedPreferences;


    public FavouriteFragment() {
        // Required empty public constructor
    }

    public static FavouriteFragment newInstance(int pageNo) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        FavouriteFragment fragment = new FavouriteFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.favourite_fragment, container, false);

        favRecycler= (RecyclerView) view.findViewById(R.id.favRecycler);
        favRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getActivity());


        Log.v("favouritids",sharedPreferences.getInt("id",-1)+"sss");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterfaceHospitals api=retrofit.create(ApiInterfaceHospitals.class);
        Call<HospitalsDataModel> conn=api.getHospitals();
        conn.enqueue(new Callback<HospitalsDataModel>() {
            @Override
            public void onResponse(Call<HospitalsDataModel> call, Response<HospitalsDataModel> response) {
                Log.v("ddd",response.body().getResults().get(0).getName());


                favRecycler.setAdapter(new HospitalRecyclerAdapter(getActivity(),response.body()));
            }

            @Override
            public void onFailure(Call<HospitalsDataModel> call, Throwable t) {
                Log.v("ddd",t.getMessage()+">>>>>");

            }
        });






        return view;
    }




}
