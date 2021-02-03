package com.tyagiabhinav.restaurantapp;


import android.util.Log;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRestaurantList {
    private static final String TAG = "TestRestaurantList";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test Recycler View presence on launch of app
     */
    @Test
    public void test01_RecyclerViewPresentOnLoad() {
        Log.d(TAG, "running test01_RecyclerViewPresentOnLoad...");

        // checks if recycler view is present
        onView(withId(R.id.restaurantRecyclerLayout)).check(matches(isDisplayed()));
    }

    /**
     * Test list scrolling and click
     */
    @Test
    public void test02_ScrollRecyclerViewOnStoreFeed() {
        Log.d(TAG, "running test02_ScrollRecyclerViewOnStoreFeed...");

        // scroll recycler view to position 5
        onView(withId(R.id.restaurantRecyclerLayout)).perform(RecyclerViewActions.scrollToPosition(5));

    }



}
