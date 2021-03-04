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
        fetchStoreFeed();
    }

    /**
     * set the location to fetch the store feed from the service
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
     */
    private void fetchStoreFeed(){
        isLoading.postValue(true);
        Call<StoreFeed> call = storeFeedAPI.getStoreFeed();
        call.enqueue(new Callback<StoreFeed>() {
            @Override
            public void onResponse(Call<StoreFeed> call, Response<StoreFeed> response) {
                // StoreFeed
                // list store
                // loop->update each store from shared pref
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
