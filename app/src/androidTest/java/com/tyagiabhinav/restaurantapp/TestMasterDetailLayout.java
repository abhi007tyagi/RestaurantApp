package com.tyagiabhinav.restaurantapp;

import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.uiautomator.UiDevice;

import static android.content.Context.WINDOW_SERVICE;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMasterDetailLayout {

    private static final String TAG = "TestMasterDetailLayout";

    /**
     * Test activity rotation
     */
    @Test
    public void test01_RotateDeviceToLandscape() throws RemoteException {
        Log.d(TAG, "running test01_RotateDeviceToLandscape..");

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationLeft();


        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) ApplicationProvider.getApplicationContext().getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        int widthInDP = Math.round(dm.widthPixels / dm.density);

        if (widthInDP >= 600) {
            Log.d(TAG, widthInDP + " >= 600");
            // checks if new container is visible
            onView(withId(R.id.restaurantDetailFragment)).check(matches(isDisplayed()));

        } else {
            Log.d(TAG, widthInDP + " < 600");
            // rotate back
            device.setOrientationRight();
        }
    }

}
