package com.example.meu_transporte_mobile.resource;


import com.example.meu_transporte_mobile.model.Driver;
import com.example.meu_transporte_mobile.model.Qualquer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface DriversResource {

    @GET("drivers")
    Call<Qualquer> get();

    @POST("drivers")
    Call<Driver> post(@Body Driver driver);

    @PUT("drivers")
    Call<Driver> put(@Body Driver driver);

    @DELETE("drivers/{id}")
    Call<Void> delete(@Path("id") int id);
}
