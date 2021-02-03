package com.tyagiabhinav.restaurantapp.model;

import android.content.Context;

import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantRepository {

    private StoreFeedAPI storeFeedAPI;
    private MutableLiveData<StoreFeed> storFeed;
    MutableLiveData<Boolean> isLoading;
    public RestaurantRepository (Context context){
        isLoading = new MutableLiveData<>();
        storeFeedAPI = RestaurantService.getInstance(context).create(StoreFeedAPI.class);
        storFeed = new MutableLiveData<>();
    }

    /**
     * set the location to fetch the store feed from the service
     *
     * @param lat
     * @param lng
     */
    public void setLocationAndFetchStoreFeed(String lat, String lng){
        fetchStoreFeed(lat, lng);
    }

    /**
     *
     * @return LiveData<StoreFeed>
     */
    public LiveData<StoreFeed> getStoreFeed(){
        return storFeed;
    }

    /**
     * if network call is still going on or not to show progress bar
     *
     * @return LiveData<Boolean>
     */
    public LiveData<Boolean> isLoading() {
        return isLoading;
    }

    /**
     * fetch store feed based on latitude and longitude
     *
     * @param lat
     * @param lng
     */
    private void fetchStoreFeed(String lat, String lng){
        isLoading.postValue(true);
        Call<StoreFeed> call = storeFeedAPI.getStoreFeed(lat, lng, 0, 50);
        call.enqueue(new Callback<StoreFeed>() {
            @Override
            public void onResponse(Call<StoreFeed> call, Response<StoreFeed> response) {
                storFeed.postValue(response.body());
                isLoading.postValue(false);
            }

            @Override
            public void onFailure(Call<StoreFeed> call, Throwable t) {
                isLoading.postValue(false);
            }
        });
    }

}
