package com.example.meu_transporte_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Route;
import com.example.meu_transporte_mobile.model.Users;

import java.util.ArrayList;
import java.util.List;


public class RouteAdapter extends BaseAdapter {
    private Context context;
    private List<Route> listRoute = new ArrayList<>();

    public RouteAdapter(final Context applicationContext, final List<Route> listRoute){
        this.context = applicationContext;
        this.listRoute = listRoute;
    }


    @Override
    public int getCount() {
        return listRoute.size();
    }

    @Override
    public Object getItem(int position) {
        return listRoute.get(position);
    }

    private Route parsetItem(int position){
        return this.listRoute.get(position);
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


        Route route = parsetItem(position);


        TextView txtId;


        txtId = layout.findViewById(R.id.txtId);

        txtId.setText(String.valueOf(route.getIdRoute()));

        return layout;
    }
}
