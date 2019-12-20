package com.example.progmobile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.LocationServices;

import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment {
    private RecyclerView LeagueOfLegendsRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<LeagueOfLegends> LeagueOfLegendsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        LeagueOfLegendsRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        appelAPI();

        return view;
    }

    void appelAPI(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_REST.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        final API_REST response = retrofit.create(API_REST.class);
        Call<List<LeagueOfLegends>> call = (response).GetLeagueOfLegends();
        call.enqueue(new Callback<List<LeagueOfLegends>>() {
            @Override
            public void onResponse(Call<List<LeagueOfLegends>> call, Response<List<LeagueOfLegends>> response) {
                LeagueOfLegendsList=response.body();
                creationList(LeagueOfLegendsList);
            }

            @Override
            public void onFailure(Call<List<LeagueOfLegends>> call, Throwable t) {
                Log.d("ERROR", "API ERROR");
            }
        });
    }

    void creationList(List<LeagueOfLegends> LeagueOfLegendsList){


        LeagueOfLegends lol = new LeagueOfLegends();
        lol.setName("Tweed");
        lol.setAge("Tweed");

        layoutManager = new LinearLayoutManager(getContext());
        LeagueOfLegendsRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(LeagueOfLegendsList);
        LeagueOfLegendsRecyclerView.setAdapter(mAdapter);


    }
}

