package com.tyagiabhinav.restaurantapp.view.restaurantlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.databinding.FragmentRestaurantListBinding;
import com.tyagiabhinav.restaurantapp.model.pojo.Store;
import com.tyagiabhinav.restaurantapp.viewmodel.RestaurantViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantListFragment extends Fragment implements RestaurantListRecyclerAdapter.OnStoreSelectedListener {

    private static final String TAG = "RestaurantListFragment";
    private boolean isTablet;
    private FragmentRestaurantListBinding binding;
    private RestaurantViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        isTablet = requireContext().getResources().getBoolean(R.bool.isTablet);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurant_list, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(requireActivity()).get(RestaurantViewModel.class);
        viewModel.getStoreFeed().observe(getViewLifecycleOwner(), storeFeed -> {
            // update UI
            RestaurantListRecyclerAdapter adapter = new RestaurantListRecyclerAdapter(storeFeed.getStores(), this);
            RecyclerView recyclerview = binding.restaurantRecyclerLayout.restaurantList;
            recyclerview.setAdapter(adapter);
            recyclerview.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
            if (isTablet && storeFeed.getStores().size() > 0) {
                // set first store for detail as default in tablet
                viewModel.setSelectedStore(storeFeed.getStores().get(0));
            }
        });
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onStoreSelected(Store store) {
        viewModel.setSelectedStore(store);
        if (isTablet) {
            NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.navHostFragmentLand);
            navHostFragment.getNavController().navigate(R.id.restaurantDetailFragment);
        } else {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_list_to_detail);
        }
    }
}