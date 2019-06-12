package com.example.meu_transporte_mobile.resource;


import com.example.meu_transporte_mobile.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface UsersResource {

    @GET("users")
    Call<List<Users>> get();

    @POST("users")
    Call<Users> post(@Body Users user);

    @PUT("users")
    Call<Users> put(@Body Users user);

    @DELETE("users/{id}")
    Call<Void> delete(@Path("id") int id);
}
