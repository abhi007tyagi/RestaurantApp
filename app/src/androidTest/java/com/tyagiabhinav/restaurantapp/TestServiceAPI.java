package com.tyagiabhinav.restaurantapp;

import android.content.Context;
import android.util.Log;

import com.tyagiabhinav.restaurantapp.model.RestaurantService;
import com.tyagiabhinav.restaurantapp.model.StoreFeedAPI;
import com.tyagiabhinav.restaurantapp.model.pojo.StoreFeed;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestServiceAPI {
    private static final String TAG = "TestServiceAPI";

    private StoreFeedAPI storeFeedAPI;

    @Before
    public void setUp() {
        // set context
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        // set storeFeedAPI
        storeFeedAPI = RestaurantService.getInstance(context).create(StoreFeedAPI.class);
    }

    @Test
    public void test01_FetchStoreFeed() {
        Log.d(TAG, "running test01_FetchStoreFeed...");
        CountDownLatch latch = new CountDownLatch(1);
        Call<StoreFeed> call = storeFeedAPI.getStoreFeed();//storeFeedAPI.getStoreFeed("37.422740", "-122.139956", 0, 50);
        call.enqueue(new Callback<StoreFeed>() {
            @Override
            public void onResponse(Call<StoreFeed> call, Response<StoreFeed> response) {
                Log.d("Test", "onResponse: " + response.body());
                assertEquals(response.body().getStores().size(), 50);
                latch.countDown();
            }

            @Override
            public void onFailure(Call<StoreFeed> call, Throwable t) {
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}