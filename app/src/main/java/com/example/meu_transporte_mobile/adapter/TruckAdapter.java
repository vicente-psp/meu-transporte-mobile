package com.example.meu_transporte_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Truck;
import com.example.meu_transporte_mobile.model.Users;

import java.util.ArrayList;
import java.util.List;


public class TruckAdapter extends BaseAdapter {
    private Context context;
    private List<Truck> listTruck = new ArrayList<>();

    public TruckAdapter(final Context applicationContext, final List<Truck> listTruck){
        this.context = applicationContext;
        this.listTruck = listTruck;
    }


    @Override
    public int getCount() {
        return listTruck.size();
    }

    @Override
    public Object getItem(int position) {
        return listTruck.get(position);
    }

    private Truck parsetItem(int position){
        return this.listTruck.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View layout, ViewGroup viewGroup) {


        if (layout == null) {
            layout = LayoutInflater.from(context).
                    inflate(R.layout.user,
                            viewGroup, false);
        }


        Truck truck = parsetItem(position);


        TextView txtId, txtName,txtExtra;



        txtId = layout.findViewById(R.id.txtId);
        txtName = layout.findViewById(R.id.txtName);
        txtExtra = layout.findViewById(R.id.txtExtra);

        txtId.setText(String.valueOf(truck.getIdTruck()));
        txtName.setText(truck.getModel());
        txtExtra.setText(truck.getBoard());


        return layout;
    }
}
