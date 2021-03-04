package com.tyagiabhinav.restaurantapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Location;

import com.tyagiabhinav.restaurantapp.model.RestaurantRepository;
import com.tyagiabhinav.restaurantapp.model.SharedPrefManager;
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

    /**
     * set the location to fetch the store feed from the service
     *
     * @param lat
     * @param lng
     */
    public void setLocationAndInitiateStoreFeed(String lat, String lng) {
        this.isLocationAvailable = true;
        restaurantRepository.setLocationAndFetchStoreFeed(lat, lng);
    }

    /**
     * if location has been set or not
     *
     * @return boolean
     */
    public boolean isLocationAvailable() {
        return isLocationAvailable;
    }

    /**
     * @return LiveData<StoreFeed>
     */
    public LiveData<StoreFeed> getStoreFeed() {
        return storeFeed;
    }

    /**
     * if progress bar is visible or not
     *
     * @return LiveData<Boolean>
     */
    public LiveData<Boolean> isProgressVisible() {
        return progressVisible;
    }

    /**
     * set the selected store for detail view
     *
     * @param store
     */
    public void setSelectedStore(Store store) {
        this.selectedStore.postValue(store);
    }

    /**
     * @return LiveData<Store>
     */
    public LiveData<Store> getSelectedStore() {
        return this.selectedStore;
    }

    public void setStoreLiked(String id, boolean liked){
        restaurantRepository.setStoreLiked(id, liked);
    }
}
