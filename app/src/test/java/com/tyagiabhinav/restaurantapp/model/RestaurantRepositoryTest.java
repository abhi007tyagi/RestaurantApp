package com.tyagiabhinav.restaurantapp.model;

import android.content.Context;

import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.CountDownLatch;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantRepositoryTest {

    private RestaurantRepository repo;
//    private RestaurantRepository repoSpy;

    @Mock
    private Context context;
    @Mock
    private MutableLiveData<Boolean> isLoading;
    @Mock
    private StoreFeedAPI storeFeedAPI;
    @Mock
    private Call<StoreFeed> call;
    @Captor
    private ArgumentCaptor<Callback<StoreFeed>> callback;


    @Before
    public void setUp() throws Exception {
        Mockito.when(context.getString(R.string.BASE_URL_STORE_FEED)).thenReturn("https://api.doordash.com/");
        Mockito.when(storeFeedAPI.getStoreFeed(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(call);
        repo = new RestaurantRepository(context, isLoading, storeFeedAPI, true);
//        repoSpy = Mockito.spy(repo);
    }

    @Test
    public void fetchStoreFeedTest() {
        repo.fetchStoreFeed( "1587.6298", "6187.6298");
//        Mockito.verify(isLoading).getValue().compareTo(true);
        Mockito.verify(storeFeedAPI, Mockito.times(1)).getStoreFeed(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());
        Mockito.verify(call).enqueue(callback.capture());
        callback.getValue().onFailure(call, new Throwable());
        Assert.assertEquals(repo.serviceResponse, false);
    }
}