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
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRestaurantDetail {

    private static final String TAG = "TestRestaurantDetail";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test Restaurant Detail's field's visibility
     */
    @Test
    public void test03_RestaurantDetailOnClick() {
        Log.d(TAG, "test03_RestaurantDetailOnClick...");

        // click the 6th entry
        onView(withId(R.id.restaurantRecyclerLayout)).perform(RecyclerViewActions.actionOnItemAtPosition(6, click()));

        // checks if restaurant logo is present
        onView(withId(R.id.logo)).check(matches(isDisplayed()));

        // checks if restaurant name is present
        onView(withId(R.id.name)).check(matches(isDisplayed()));

        // checks if distance is present
        onView(withId(R.id.distance)).check(matches(isDisplayed()));

        // checks if description is present
        onView(withId(R.id.description)).check(matches(isDisplayed()));

        // checks if delivery fee is present
        onView(withId(R.id.deliveryFee)).check(matches(isDisplayed()));

        // checks if menu pager view is present
        onView(withId(R.id.menuPager)).check(matches(isDisplayed()));
    }

    /**
     * Test menu scrolling
     */
    @Test
    public void test04_ScrollMenuPagerViewOnLoadOfDetails() {
        Log.d(TAG, "running test04_ScrollMenuPagerViewOnLoadOfDetails...");

        // click the 1th entry
        onView(withId(R.id.restaurantRecyclerLayout)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        // checks if menu pager view is present
        onView(withId(R.id.menuPager)).check(matches(isDisplayed()));

        // swipe menu pager view to left
        onView(withId(R.id.menuPager)).perform(swipeLeft());

        // swipe menu pager view to right
        onView(withId(R.id.menuPager)).perform(swipeRight());
    }
}
