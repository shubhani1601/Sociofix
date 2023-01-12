package com.example.sociofix.retrofit;
import com.google.gson.Gson;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService() {
        inititializeRetrofit();
    }

    private void inititializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.32:8080")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}