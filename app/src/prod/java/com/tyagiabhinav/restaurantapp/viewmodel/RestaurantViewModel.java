package com.tyagiabhinav.restaurantapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Location;

import com.tyagiabhinav.restaurantapp.model.RestaurantRepository;
import com.tyagiabhinav.restaurantapp.model.pojo.Store;
import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RestaurantViewModel extends AndroidViewModel {

    private RestaurantRepository restaurantRepository;
    private LiveData<StoreFeed> storeFeed;
    private LiveData<Boolean> progressVisible;
    private MutableLiveData<Store> selectedStore;
    private boolean isLocationAvailable = false;


    public RestaurantViewModel(@NonNull Application application) {
        super(application);
        selectedStore = new MutableLiveData<>();
        restaurantRepository = new RestaurantRepository(application.getApplicationContext());
        progressVisible = restaurantRepository.isLoading();
        storeFeed = restaurantRepository.getStoreFeed();
    }

    public void setLocationAndInitiateStoreFeed(String lat, String lng) {
        this.isLocationAvailable = true;
        restaurantRepository.setLocationAndFetchStoreFeed(lat, lng);
    }

    public boolean isLocationAvailable(){
        return isLocationAvailable;
    }

    public LiveData<StoreFeed> getStoreFeed() {
        return storeFeed;
    }

    public LiveData<Boolean> isProgressVisible() {
        return progressVisible;
    }

    public void setSelectedStore(Store store) {
        this.selectedStore.postValue(store);
    }

    public LiveData<Store> getSelectedStore() {
        return this.selectedStore;
    }
}
