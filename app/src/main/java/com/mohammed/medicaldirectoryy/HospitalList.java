package com.mohammed.medicaldirectoryy;

import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HospitalList extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPageNo;

    RecyclerView hospitalList;

    public HospitalList() {
        // Required empty public constructor
    }

    public static HospitalList newInstance(int pageNo) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);
        HospitalList fragment = new HospitalList();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        hospitalList= (RecyclerView) view.findViewById(R.id.hospitalList);
        hospitalList.setLayoutManager(new LinearLayoutManager(getActivity()));

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
                hospitalList.setAdapter(new HospitalRecyclerAdapter(getActivity(),response.body()));
            }

            @Override
            public void onFailure(Call<HospitalsDataModel> call, Throwable t) {
                Log.v("ddd",t.getMessage()+">>>>>");

            }
        });


//        TextView textView = (TextView) view;
//        textView.setText("Fragment #" + mPageNo);
       // init_views(view);

//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                int numberOfBtn=0;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=1;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=2;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=3;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=4;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=5;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=6;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=7;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=8;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });
//        btn10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int numberOfBtn=9;
//                Intent btn_number= new Intent(getActivity(), HospitalDetails.class);
//                btn_number.putExtra("key",numberOfBtn);
//                startActivity(btn_number);
//
//            }
//        });

        return view;
    }

    private void init_views(View view) {
//        btn1 = (Button) view.findViewById(R.id.btn_hospital_1);
//        btn2 = (Button) view.findViewById(R.id.btn_hospital_2);
//        btn3 = (Button) view.findViewById(R.id.btn_hospital_3);
//        btn4 = (Button) view.findViewById(R.id.btn_hospital_4);
//        btn5 = (Button) view.findViewById(R.id.btn_hospital_5);
//        btn6 = (Button) view.findViewById(R.id.btn_hospital_6);
//        btn7 = (Button) view.findViewById(R.id.btn_hospital_7);
//        btn8 = (Button) view.findViewById(R.id.btn_hospital_8);
//        btn9 = (Button) view.findViewById(R.id.btn_hospital_9);
//        btn10 = (Button) view.findViewById(R.id.btn_hospital_10);
    }




}
