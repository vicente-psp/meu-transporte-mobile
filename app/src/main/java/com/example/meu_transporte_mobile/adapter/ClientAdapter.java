package com.example.meu_transporte_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Client;

import java.util.ArrayList;
import java.util.List;


public class ClientAdapter extends BaseAdapter {
    private Context context;
    private List<Client> listClient = new ArrayList<>();

    public ClientAdapter(final Context applicationContext, final List<Client> listClient){
        this.context = applicationContext;
        this.listClient = listClient;
    }


    @Override
    public int getCount() {
        return listClient.size();
    }

    @Override
    public Object getItem(int position) {
        return listClient.get(position);
    }

    private Client parsetItem(int position){
        return this.listClient.get(position);
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


        Client client = parsetItem(position);


        TextView txtId, txtName,txtExtra;



        txtId = layout.findViewById(R.id.txtId);
        txtName = layout.findViewById(R.id.txtName);
        txtExtra = layout.findViewById(R.id.txtExtra);

        txtId.setText(String.valueOf(client.getIdClient()));
        txtName.setText(client.getName());
        txtExtra.setText(client.getCnpj());


        return layout;
    }
}
