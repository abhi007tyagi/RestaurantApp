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
import com.tyagiabhinav.restaurantapp.databinding.ActivityMainBinding;
import com.tyagiabhinav.restaurantapp.viewmodel.RestaurantViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int LOCATION_REQUEST_CODE = 999;
    private NavController navController;
    private FusedLocationProviderClient fusedLocationClient;
    private MutableLiveData<Location> location;
    private RestaurantViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        navController = Navigation.findNavController(this, R.id.navHostFragmentMain);
        NavigationUI.setupActionBarWithNavController(this, navController);
        // initialize location client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        // initialize view model
        viewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        // create and observe location to trigger service call
        location = new MutableLiveData<>();
        location.observe(this, location -> {
            // set location and call store feed api
            viewModel.setLocationAndInitiateStoreFeed(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        askPermission();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
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

    /**
     * set the last know location to fetch the store feed
     */
    private void setLocation() {
        // if location was not set... move ahead and get the location and set it
        if (!viewModel.isLocationAvailable()) {
            // suppress  is added as there will be a warning to add permission check before calling lastLocation
            // which we are doing from the calling source
            @SuppressLint("MissingPermission") Task<Location> lastLocation = fusedLocationClient.getLastLocation();
            lastLocation.addOnSuccessListener(location -> {
                // set the location in live data
                this.location.postValue(location);
            });
        }
    }

    /**
     * ask location permission if not granted otherwise continue
     */
    private void askPermission() {
        // check for required permission
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // permission granted... move ahead
            setLocation();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // show user message on why permission is required
                showWhyPermissionRequiredDialog();
            } else {
                // ask permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
            }
        }
    }

    /**
     * shows user dialog for why they need to give permission
     */
    private void showWhyPermissionRequiredDialog() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.why_permission_required)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
                }).show();
    }


}