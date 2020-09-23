package com.example.kessseller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.50.47:8000/";

    public static Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
    public static GetDataRoom getDataRoom(){
        GetDataRoom dataRoom = getRetrofit().create(GetDataRoom.class);
        return dataRoom;
    }
}
