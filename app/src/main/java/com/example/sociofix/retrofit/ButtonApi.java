package com.example.sociofix.retrofit;

import com.example.sociofix.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ButtonApi {
    @POST("/demo2/write")
    Call<Person> write(@Body Person person);
}
