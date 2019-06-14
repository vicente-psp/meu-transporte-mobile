package com.example.meu_transporte_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Product;
import com.example.meu_transporte_mobile.model.Users;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;


public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> listProduct = new ArrayList<>();

    public ProductAdapter(final Context applicationContext, final List<Product> listProduct){
        this.context = applicationContext;
        this.listProduct = listProduct;
    }


    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    private Product parsetItem(int position){
        return this.listProduct.get(position);
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


        Product product = parsetItem(position);


        TextView txtId, txtName,txtExtra;



        txtId = layout.findViewById(R.id.txtId);
        txtName = layout.findViewById(R.id.txtName);
        txtExtra = layout.findViewById(R.id.txtExtra);

        txtId.setText(valueOf(product.getIdProduct()));
        txtName.setText(product.getDescription());
        txtExtra.setText(valueOf(product.getValue()));


        return layout;
    }
}
