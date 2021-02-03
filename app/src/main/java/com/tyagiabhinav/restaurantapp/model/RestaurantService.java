package com.tyagiabhinav.restaurantapp.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tyagiabhinav.restaurantapp.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantService {

    private static Retrofit instance;
    public static synchronized Retrofit getInstance(Context context) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if(instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(context.getString(R.string.BASE_URL_STORE_FEED))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return instance;
    }
}
