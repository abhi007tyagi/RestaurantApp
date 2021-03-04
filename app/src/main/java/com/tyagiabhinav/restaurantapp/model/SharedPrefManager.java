package com.tyagiabhinav.restaurantapp.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static String SHARED_PREF = "SHARED_PREF";
    // properties
    private static final String ID = "id_store";

    private SharedPrefManager() {
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }

    public static boolean getLikeForStoreById(Context context, String id) {
        return getSharedPreferences(context).getBoolean(id, false);
    }

    public static void setLikeForStoreById(Context context, String id, boolean isLiked) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(id, isLiked);
        editor.apply();
    }
}