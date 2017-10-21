package com.mohammed.medicaldirectoryy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohammed.medicaldirectoryy.Home;
import com.mohammed.medicaldirectoryy.HospitalDetails;
import com.mohammed.medicaldirectoryy.R;
import com.mohammed.medicaldirectoryy.model.HospitalsDataModel;

/**
 * Created by mohammed on 5/10/17.
 */

public class HospitalRecyclerAdapter extends RecyclerView.Adapter<HospitalRecyclerAdapter.MyHolder> {

    Context context;
    public static  HospitalsDataModel list;

    public HospitalRecyclerAdapter(Context context, HospitalsDataModel list) {
    this.context=context;
        this.list=list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);

        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.name.setText(list.getResults().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.getResults().size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        CardView layoutClick;

        public MyHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name_hospital);
            layoutClick= (CardView) itemView.findViewById(R.id.linearclick);
            layoutClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(((Home)context), HospitalDetails.class);
            intent.putExtra("index",getAdapterPosition());
            HospitalDetails.lat=list.getResults().get(getAdapterPosition()).getLat();
            HospitalDetails.lng=list.getResults().get(getAdapterPosition()).getLang();
            ((Home)context).startActivity(intent);
        };
    }
}
