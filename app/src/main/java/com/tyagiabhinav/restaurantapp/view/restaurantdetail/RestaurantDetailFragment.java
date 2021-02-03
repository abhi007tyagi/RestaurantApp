package com.tyagiabhinav.restaurantapp.view.restaurantdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayoutMediator;
import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.databinding.FragmentRestaurantDetailBinding;
import com.tyagiabhinav.restaurantapp.model.pojo.Store;
import com.tyagiabhinav.restaurantapp.viewmodel.RestaurantViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

public class RestaurantDetailFragment extends Fragment {

    private FragmentRestaurantDetailBinding binding;
    private RestaurantViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurant_detail, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(requireActivity()).get(RestaurantViewModel.class);
        viewModel.getSelectedStore().observe(getViewLifecycleOwner(), store -> {
            // update UI
            binding.menuPager.setAdapter(new PopularMenuItemAdapter(store.getMenus().get(0).getPopularItems()));
            binding.setStore(store);
            // set the navigation highlight DOT for pager view
            new TabLayoutMediator(binding.dotTab, binding.menuPager, (tab, position) -> tab.select()).attach();
        });
        return binding.getRoot();
    }
}