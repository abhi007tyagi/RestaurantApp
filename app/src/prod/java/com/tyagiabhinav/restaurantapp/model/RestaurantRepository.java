package com.tyagiabhinav.restaurantapp.model;

import android.content.Context;

import com.tyagiabhinav.restaurantapp.model.pojo.Store;
import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantRepository {

    private Context context;
    private StoreFeedAPI storeFeedAPI;
    private MutableLiveData<StoreFeed> storFeed;
    private MutableLiveData<Boolean> isLoading;
    public boolean serviceResponse;
    public RestaurantRepository (Context ctx){
        context = ctx;
        isLoading = new MutableLiveData<>();
        storeFeedAPI = RestaurantService.getInstance(context).create(StoreFeedAPI.class);
        storFeed = new MutableLiveData<>();
    }

    public RestaurantRepository (Context context, MutableLiveData<Boolean> loading, StoreFeedAPI api, boolean response){
        isLoading = loading;
        storeFeedAPI = api;
        serviceResponse = response;
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
    public void fetchStoreFeed(String lat, String lng){
        isLoading.postValue(true);
        Call<StoreFeed> call = storeFeedAPI.getStoreFeed(lat, lng, 0, 50);
        call.enqueue(new Callback<StoreFeed>() {
            @Override
            public void onResponse(Call<StoreFeed> call, Response<StoreFeed> response) {
                StoreFeed feed = response.body();
                List<Store> storeList = feed.getStores();
                for(Store store: storeList){
                    store.setLiked(SharedPrefManager.getLikeForStoreById(context, store.getId()));
                }
                feed.setStores(storeList);
                storFeed.postValue(feed);
                isLoading.postValue(false);
                serviceResponse = true;
            }

            @Override
            public void onFailure(Call<StoreFeed> call, Throwable t) {
                serviceResponse = false;
                isLoading.postValue(false);
            }
        });
    }

    public void setStoreLiked(String id, boolean liked) {
        SharedPrefManager.setLikeForStoreById(context, id, liked);
    }
}
