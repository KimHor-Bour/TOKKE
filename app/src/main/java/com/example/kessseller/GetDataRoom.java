package com.example.kessseller;

import com.example.kessseller.Data.DataItemBookingRoom;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface GetDataRoom {
    @GET("api/rooms")
    @Headers("APP_KEY:#vann123")
    Call<List<DataItemBookingRoom>> getAllRoom();
}
