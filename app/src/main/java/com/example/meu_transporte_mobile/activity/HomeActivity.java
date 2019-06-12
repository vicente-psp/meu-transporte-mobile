package com.example.meu_transporte_mobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.meu_transporte_mobile.R;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void show(View view) {

        switch (view.getId()){

            case R.id.btnDrivers:

                Intent intent = new Intent(this, UsersActivity.class);
                startActivity(intent);

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
