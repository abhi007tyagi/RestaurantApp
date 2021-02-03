package com.tyagiabhinav.restaurantapp.model;

import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StoreFeedAPI {

    /**
     * get store feed
     * @param lat
     * @param lng
     * @param offset
     * @param limit
     * @return
     */
    @GET("/v1/store_feed/")  //?lat=37.422740&lng=-122.139956&offset=0&limit=50
    Call<StoreFeed> getStoreFeed(@Query("lat")String lat, @Query("lng") String lng,
                                 @Query("offset") int offset, @Query("limit") int limit);
}
