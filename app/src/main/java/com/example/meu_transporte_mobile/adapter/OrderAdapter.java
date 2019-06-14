package com.example.meu_transporte_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Order;
import com.example.meu_transporte_mobile.model.Users;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;


public class OrderAdapter extends BaseAdapter {
    private Context context;
    private List<Order> listOrder = new ArrayList<>();

    public OrderAdapter(final Context applicationContext, final List<Order> listOrder){
        this.context = applicationContext;
        this.listOrder = listOrder;
    }


    @Override
    public int getCount() {
        return listOrder.size();
    }

    @Override
    public Object getItem(int position) {
        return listOrder.get(position);
    }

    private Order parsetItem(int position){
        return this.listOrder.get(position);
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


        Order order = parsetItem(position);


        TextView txtId, txtName,txtExtra;



        txtId = layout.findViewById(R.id.txtId);
        txtName = layout.findViewById(R.id.txtName);
        txtExtra = layout.findViewById(R.id.txtExtra);

        txtId.setText(valueOf(order.getIdOrder()));
        txtName.setText(valueOf(order.getNameClient()));
        txtExtra.setText(valueOf(order.getValue()));


        return layout;
    }
}
