package com.tyagiabhinav.restaurantapp;

import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.uiautomator.UiDevice;

import static android.content.Context.WINDOW_SERVICE;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMasterDetailLayout {

    private static final String TAG = "TestMasterDetailLayout";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);


    /**
     * Test master detail layout on tablet
     */
    @Test
    public void test01_MasterDetailLayout() throws RemoteException {
        Log.d(TAG, "running test01_MasterDetailLayout...");

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationLeft();


        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) ApplicationProvider.getApplicationContext().getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        int widthInDP = Math.round(dm.widthPixels / dm.density);

        if (widthInDP >= 600) {
            Log.d(TAG, widthInDP + " >= 600");
            // checks if both containers are visible
            onView(withId(R.id.navHostFragmentMain)).check(matches(isDisplayed()));
            onView(withId(R.id.navHostFragmentLand)).check(matches(isDisplayed()));

        } else {
            Log.d(TAG, widthInDP + " < 600");
            // rotate back
            device.setOrientationRight();
        }
    }

}
