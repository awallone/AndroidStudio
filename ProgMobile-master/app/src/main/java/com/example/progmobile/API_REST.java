package com.example.progmobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_REST {

    String URL = " ";

    @GET("dogs_data.json")
    Call<List<LeagueOfLegends>> GetLeagueOfLegends();
}