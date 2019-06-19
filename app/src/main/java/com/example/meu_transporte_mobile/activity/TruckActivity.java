package com.example.meu_transporte_mobile.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meu_transporte_mobile.R;
import com.example.meu_transporte_mobile.adapter.ClientAdapter;
import com.example.meu_transporte_mobile.bootstrap.APIClient;
import com.example.meu_transporte_mobile.model.Client;
import com.example.meu_transporte_mobile.resource.ClientResource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Long.valueOf;

public class TruckActivity extends AppCompatActivity {

    ClientResource apiUserResourse;

    private String username;
    private String extra;
    private Integer idClient;

    EditText txtId;
    EditText txtName;
    EditText txtExtra;

    ListView listViewUsers;
    ArrayList<Client> listClient = new ArrayList<Client>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        apiUserResourse = APIClient.getClient().create(ClientResource.class);

        Call<List<Client>> get = apiUserResourse.get();

        get.enqueue(new Callback<List<Client>>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                listViewUsers = findViewById(R.id.listViewUser);
                listClient = (ArrayList<Client>) response.body();
                listViewUsers.setAdapter(new ClientAdapter(getApplicationContext(), listClient));
                registerForContextMenu(listViewUsers);
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private boolean existeId(ArrayList<Client> clients, int id) {
        for (Client client : clients) {
            if (client.getIdClient() == id)
                return true;
        }
        return false;
    }

    public void clientAdd(View view) {

        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtExtra = findViewById(R.id.txtExtra);


        idClient = Integer.parseInt(txtId.getText().toString());
        username = txtName.getText().toString();
        extra = txtExtra.getText().toString();

        final Client client = new Client();
        client.setIdClient(valueOf(idClient));
        client.setName(username);
        client.setCnpj(extra);

        Call<Client> post = apiUserResourse.post(client);
        post.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                Client u = response.body();
                listViewUsers = findViewById(R.id.listViewUser);

                if (existeId(listClient, idClient)) {
                    Toast.makeText(getApplicationContext(), "PESSOA JÁ EXISTE", Toast.LENGTH_LONG).show();
                    txtExtra.setText("");
                    txtId.setText("");
                    txtName.setText("");
                } else {

                    listClient.add(client);

                    listViewUsers.setAdapter(new ClientAdapter(getApplicationContext(), listClient));

                }

            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
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
