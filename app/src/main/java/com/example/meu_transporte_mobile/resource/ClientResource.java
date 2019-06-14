package com.example.meu_transporte_mobile.resource;


import com.example.meu_transporte_mobile.model.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ClientResource {

    @GET("client")
    Call<List<Client>> get();

    @POST("client")
    Call<Client> post(@Body Client client);

    @PUT("client")
    Call<Client> put(@Body Client client);

    @DELETE("client/{id}")
    Call<Void> delete(@Path("id") int id);
}
