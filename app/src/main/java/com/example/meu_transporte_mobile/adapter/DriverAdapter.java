package com.example.meu_transporte_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Driver;

import java.util.ArrayList;
import java.util.List;


public class DriverAdapter extends BaseAdapter {
    private Context context;
    private List<Driver> listDriver = new ArrayList<Driver>();

    public DriverAdapter(final Context applicationContext, final List<Driver> listDriver){
        this.context = applicationContext;
        this.listDriver = listDriver;
    }


    @Override
    public int getCount() {
        return listDriver.size();
    }

    @Override
    public Object getItem(int position) {
        return listDriver.get(position);
    }

    private Driver parsetItem(int position){
        return this.listDriver.get(position);
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


        Driver driver = parsetItem(position);


        TextView txtId, txtName,txtPhone;



        txtId = layout.findViewById(R.id.txtIdUser);
        txtName = layout.findViewById(R.id.txtName);
        txtPhone = layout.findViewById(R.id.txtPhone);

        txtId.setText(String.valueOf(driver.getIdUser()));
        txtName.setText(driver.getName());
        txtPhone.setText(driver.getPhone());


        return layout;
    }
}
