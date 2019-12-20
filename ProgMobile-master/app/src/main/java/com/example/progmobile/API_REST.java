package com.example.progmobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_REST {

    String URL = "https://raw.githubusercontent.com/awallone/AndroidStudio/master/ProgMobile-master/app/";

    @GET("dogs_data.json")
    Call<List<LeagueOfLegends>> GetLeagueOfLegends();
}