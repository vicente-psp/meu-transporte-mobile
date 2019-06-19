package com.example.meu_transporte_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.model.Driver;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void show(View view) {

        switch (view.getId()){

            case R.id.btnDrivers:

                Intent intentDrivers = new Intent(this, DriverActivity.class);
                startActivity(intentDrivers);

                break;

            case R.id.btnClient:

                Intent intent2 = new Intent(this, ClientActivity.class);
                startActivity(intent2);

                break;

            case R.id.btnMaps:

                Intent intentMaps = new Intent(this, MapsActivity.class);
                startActivity(intentMaps);

                break;

            default:
                Toast.makeText(this,
                        "Erro ao selecionar opção",
                        Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
