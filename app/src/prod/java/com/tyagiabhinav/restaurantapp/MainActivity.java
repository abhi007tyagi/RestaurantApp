package com.tyagiabhinav.restaurantapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.tyagiabhinav.restaurantapp.viewmodel.RestaurantViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int LOCATION_REQUEST_CODE = 999;
    private FusedLocationProviderClient fusedLocationClient;
    private MutableLiveData<Location> location;
    private RestaurantViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        viewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        location = new MutableLiveData<>();
        location.observe(this, location -> {
            viewModel.setLocationAndInitiateStoreFeed(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        askPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: " + requestCode);
        if (requestCode == LOCATION_REQUEST_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // granted
            setLocation();
        } else {
            // not granted
            showWhyPermissionRequiredDialog();
        }
    }

    private void setLocation() {
        if (!viewModel.isLocationAvailable()) {
            @SuppressLint("MissingPermission") Task<Location> lastLocation = fusedLocationClient.getLastLocation();
            lastLocation.addOnSuccessListener(location -> {
                this.location.postValue(location);
            });
        }
    }

    private void askPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // permission granted
            setLocation();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                showWhyPermissionRequiredDialog();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
            }
        }
    }

    private void showWhyPermissionRequiredDialog() {
        new AlertDialog.Builder(getApplicationContext())
                .setMessage(R.string.why_permission_required)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
                }).show();
    }


}