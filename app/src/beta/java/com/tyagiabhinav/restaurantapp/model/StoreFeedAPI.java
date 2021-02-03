package com.tyagiabhinav.restaurantapp.model;

import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StoreFeedAPI {

    /**
     * get store feed for location lat=37.422740&lng=-122.139956
     *
     * @return
     */
    @GET("/v1/store_feed/?lat=37.422740&lng=-122.139956&offset=0&limit=50")
    Call<StoreFeed> getStoreFeed();
}
