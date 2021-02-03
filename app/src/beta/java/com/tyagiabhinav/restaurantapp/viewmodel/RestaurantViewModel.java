package com.tyagiabhinav.restaurantapp.viewmodel;

import android.app.Application;

import com.tyagiabhinav.restaurantapp.model.RestaurantRepository;
import com.tyagiabhinav.restaurantapp.model.pojo.Store;
import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RestaurantViewModel extends AndroidViewModel {

    RestaurantRepository restaurentRepository;
    LiveData<StoreFeed> storeFeed;
    LiveData<Boolean> progressVisible;
    MutableLiveData<Store> selectedStore;


    public RestaurantViewModel(@NonNull Application application) {
        super(application);

        selectedStore = new MutableLiveData<>();
        restaurentRepository = new RestaurantRepository(application.getApplicationContext());
        progressVisible = restaurentRepository.isLoading();
        storeFeed = restaurentRepository.getStoreFeed();
    }

    public LiveData<StoreFeed> getStoreFeed(){
        return storeFeed;
    }

    public LiveData<Boolean> isProgressVisible() {
        return progressVisible;
    }

    public void setSelectedStore(Store store){
        this.selectedStore.postValue(store);
    }

    public LiveData<Store> getSelectedStore(){
        return this.selectedStore;
    }
}
