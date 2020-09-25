package com.example.kessseller;


import com.example.kessseller.Model.ModelRoomList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface PlaceholderAPI {
    @GET("api/rooms")
    @Headers("APP_KEY:#vann123")
    Call<JSONResponse> getAllRoom();
}
