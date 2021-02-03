package com.tyagiabhinav.restaurantapp.view.restaurantlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.databinding.ItemRestaurantBinding;
import com.tyagiabhinav.restaurantapp.model.pojo.Store;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantListRecyclerAdapter extends RecyclerView.Adapter<RestaurantListRecyclerAdapter.StoreFeedViewHolder> {

    List<Store> storeList;
    OnStoreSelectedListener onStoreSelectedListener;

    public RestaurantListRecyclerAdapter(List<Store> storeFeed, OnStoreSelectedListener onStoreSelectedListener) {
        this.storeList = storeFeed;
        this.onStoreSelectedListener = onStoreSelectedListener;
    }

    @NonNull
    @Override
    public StoreFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRestaurantBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_restaurant, parent, false);
        return new StoreFeedViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreFeedViewHolder holder, int position) {
        holder.bind(storeList.get(position), onStoreSelectedListener);
    }

    @Override
    public int getItemCount() {
        return storeList != null ? storeList.size() : 0;
    }

    class StoreFeedViewHolder extends RecyclerView.ViewHolder {

        ItemRestaurantBinding binding;

        public StoreFeedViewHolder(@NonNull ItemRestaurantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Store store, OnStoreSelectedListener onStoreSelectedListener) {
            this.binding.setOnStoreSelected(onStoreSelectedListener);
            this.binding.setStore(store);
            this.binding.executePendingBindings();
        }
    }

    public interface OnStoreSelectedListener {
        void onStoreSelected(Store store);
    }
}
