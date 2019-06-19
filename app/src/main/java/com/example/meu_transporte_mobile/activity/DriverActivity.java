package com.example.meu_transporte_mobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatViewInflater;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.adapter.DriverAdapter;
import com.example.meu_transporte_mobile.bootstrap.APIClient;
import com.example.meu_transporte_mobile.model.Driver;
import com.example.meu_transporte_mobile.model.Qualquer;
import com.example.meu_transporte_mobile.resource.DriversResource;
import com.example.meu_transporte_mobile.utils.CnhCategory;
import com.example.meu_transporte_mobile.utils.Gender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Long.valueOf;

public class DriverActivity extends AppCompatActivity {

    DriversResource apiDriversResourse;

    private String name;
    private String phone;
    private Long idUser;
    private String password;
    private String cnh;
    private String cnhCategory;
    private String userName;
    private String cpf;
    private String firstDateCnh;
    private String validityOfCnh;
    private String dateOfBirth;


    EditText txtIdUser;
    EditText txtUserName;
    EditText txtPhone;
    EditText txtName;
    EditText txtPassword;
    EditText txtDateBirth;
    EditText txtCnh;
    EditText txtCnhCategory;
    EditText txtFirstDateCnh;
    EditText txtValidityCnh;
    EditText txtCpf;

    ListView listViewDriver;
    List<Driver> listDrivers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);

        apiDriversResourse = APIClient.getClient().create(DriversResource.class);

        Call<Qualquer> get = apiDriversResourse.get();

        get.enqueue(new Callback<Qualquer>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Qualquer> call, Response<Qualquer> response) {
                listViewDriver = findViewById(R.id.listViewDriver);
                Qualquer q = (Qualquer) response.body();
                listDrivers = q.get_embedded().getDriverList();
                listViewDriver.setAdapter(new DriverAdapter(getApplicationContext(), listDrivers));
                registerForContextMenu(listViewDriver);
            }

            @Override
            public void onFailure(Call<Qualquer> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private boolean existeId(List<Driver> drivers, Long id) {
        for (Driver driver : drivers) {
            if (driver.getIdUser() == id)
                return true;
        }
        return false;
    }

    public void driverAdd(View view) {

        //txtIdUser = findViewById(R.id.txtIdUser);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
//        txtCpf = findViewById(R.id.txtCpf);
        txtUserName = findViewById(R.id.txtUserName);
//        txtCnh = findViewById(R.id.txtCnh);
        //txtCnhCategory = findViewById(R.id.txtCnhCategory);
        txtPassword = findViewById(R.id.txtPassword);
//        txtDateBirth = findViewById(R.id.txtDateBirth);
//        txtFirstDateCnh = findViewById(R.id.txtFirstDateCnh);
//        txtValidityCnh = findViewById(R.id.txtValidityCnh);


        //idUser = Long.parseLong(txtIdUser.getText().toString());
        userName = txtUserName.getText().toString();
        phone = txtPhone.getText().toString();
//        cpf = txtCpf.getText().toString();
        name = txtName.getText().toString();
        password = txtPassword.getText().toString();
//        cnh = txtCnh.getText().toString();
        //cnhCategory = txtCnhCategory.getText().toString();
//        firstDateCnh = txtFirstDateCnh.getText().toString();
//        validityOfCnh = txtValidityCnh.getText().toString();
//        dateOfBirth = txtDateBirth.getText().toString();

        final Driver drivers = Driver.builder()
                //.idUser(idUser)
                .userName(userName)
                .password(password)
                .role("ROLE_ADMIN")
                .name(name)
                .cnh("12345678912")
                .cpf("70158881141")
                .phone(phone)
                .cnhCategory(Enum.valueOf(CnhCategory.class, "A"))
                .gender(Enum.valueOf(Gender.class, "MALE"))
                .firstDateCnh("1995-05-11")
                .validityOfCnh("1995-05-11")
                .dateOfBirth("1995-05-11")
                .build();

        Call<Driver> post = apiDriversResourse.post(drivers);
        post.enqueue(new Callback<Driver>() {
            @Override
            public void onResponse(Call<Driver> call, Response<Driver> response) {
                Driver u = response.body();
                listViewDriver = findViewById(R.id.listViewDriver);

//                if (existeId(listDrivers, idUser)) {
//                    Toast.makeText(getApplicationContext(), "PESSOA JÁ EXISTE", Toast.LENGTH_LONG).show();
//                    txtPhone.setText("");
//                    txtIdUser.setText("");
//                    txtName.setText("");
//                    txtUserName.setText("");
//                    txtPassword.setText("");
//                } else {

                    listDrivers.add(drivers);

                    listViewDriver.setAdapter(new DriverAdapter(getApplicationContext(), listDrivers));



            }

            @Override
            public void onFailure(Call<Driver> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }

        });
    }
}


//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuItem deletar = menu.add("Delete");
//        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
//                Users user = (Users) listViewUsers.getItemAtPosition(info.position);
//                Call<Void> delete = apiUserResourse.delete(user.getId());
//                delete.enqueue(new Callback<Void>() {
//                   @Override
//                   public void onResponse(Call<Void> call, Response<Void> response) {
//                       apiUserResourse.delete(user.getId());
//                       Intent intent = new Intent(listViewUsers.getContext(),listUsers.getClass());
//                       startActivity(intent);
//                   }
//
//                   @Override
//                   public void onFailure(Call<Void> call, Throwable t) {
//
//                   }
//               });
//                return false;
//            }
//        });
//    }
//}








//
////
//        Call<Void> delete = apiUserResourse.delete(user);
//                delete.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//
//                    }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//
//        }
////        });
//    }
