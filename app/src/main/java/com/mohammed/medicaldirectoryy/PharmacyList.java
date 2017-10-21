package com.mohammed.medicaldirectoryy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mohammed.medicaldirectoryy.adapters.PharmacyRecyclerAdapter;
import com.mohammed.medicaldirectoryy.model.PharmacyDataModel;
import com.mohammed.medicaldirectoryy.rest.ApiInterfaceHospitals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PharmacyList extends Fragment {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPageNo;
    RecyclerView pharmacyList;


    public PharmacyList() {
        // Required empty public constructor
    }

    public static PharmacyList newInstance(int pageNo) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        PharmacyList fragment = new PharmacyList();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNo = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pharmacy, container, false);
//        TextView textView = (TextView) view;
//        textView.setText("Fragment #" + mPageNo);


        pharmacyList= (RecyclerView) view.findViewById(R.id.hospitalList);
        pharmacyList.setLayoutManager(new LinearLayoutManager(getActivity()));

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterfaceHospitals api=retrofit.create(ApiInterfaceHospitals.class);
        Call<PharmacyDataModel> conn=api.getPharmacies();
        conn.enqueue(new Callback<PharmacyDataModel>() {
            @Override
            public void onResponse(Call<PharmacyDataModel> call, Response<PharmacyDataModel> response) {
                Log.v("ddd",response.body().getResults().get(0).getName());
                pharmacyList.setAdapter(new PharmacyRecyclerAdapter(getActivity(),response.body()));
            }

            @Override
            public void onFailure(Call<PharmacyDataModel> call, Throwable t) {
                Log.v("ddd",t.getMessage()+">>>>>");

            }
        });


//        btn1 = (Button) view.findViewById(R.id.btn_pharmacy_1);
//        btn2 = (Button) view.findViewById(R.id.btn_pharmacy_2);
//        btn3 = (Button) view.findViewById(R.id.btn_pharmacy_3);
//        btn4 = (Button) view.findViewById(R.id.btn_pharmacy_4);
//        btn5 = (Button) view.findViewById(R.id.btn_pharmacy_5);
//        btn6 = (Button) view.findViewById(R.id.btn_pharmacy_6);
//        btn7 = (Button) view.findViewById(R.id.btn_pharmacy_7);
//        btn8 = (Button) view.findViewById(R.id.btn_pharmacy_8);
//        btn9 = (Button) view.findViewById(R.id.btn_pharmacy_9);
//        btn10 = (Button) view.findViewById(R.id.btn_pharmacy_10);
//
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=0;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int numberOfBtn=1;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int numberOfBtn=2;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int numberOfBtn=3;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=4;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=5;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=6;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=7;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=8;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=9;
//                Intent btn_number= new Intent(getActivity(), PharmacyDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });

        return view;
    }



}
