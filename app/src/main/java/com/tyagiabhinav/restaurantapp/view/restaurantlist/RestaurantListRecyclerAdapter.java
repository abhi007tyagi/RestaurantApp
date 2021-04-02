package com.tyagiabhinav.restaurantapp.view.restaurantlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.databinding.ItemRestaurantBinding;
import com.tyagiabhinav.restaurantapp.model.SharedPrefManager;
import com.tyagiabhinav.restaurantapp.model.pojo.Store;
import com.tyagiabhinav.restaurantapp.viewmodel.RestaurantViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class    RestaurantListRecyclerAdapter extends RecyclerView.Adapter<RestaurantListRecyclerAdapter.StoreFeedViewHolder> {

    RestaurantViewModel restaurantViewModel;
    List<Store> storeList;
    OnStoreSelectedListener onStoreSelectedListener;

    public RestaurantListRecyclerAdapter(RestaurantViewModel viewModel, List<Store> storeFeed, OnStoreSelectedListener onStoreSelectedListener) {
        this.restaurantViewModel = viewModel;
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
        holder.bind(restaurantViewModel, storeList.get(position), onStoreSelectedListener);
    }

    @Override
    public int getItemCount() {
        return storeList != null ? storeList.size() : 0;
    }

//    private void setLikeListener(ItemRestaurantBinding binding, Store store){
//        binding.likeBtn.setOnClickListener(v -> {
//            SharedPrefManager.setLikeForStoreById(context, String.valueOf(store.getId()), !store.isLiked());
//            store.setLiked(!store.isLiked());
//        });
//    }

    class StoreFeedViewHolder extends RecyclerView.ViewHolder {

        ItemRestaurantBinding binding;

        public StoreFeedViewHolder(@NonNull ItemRestaurantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RestaurantViewModel viewModel, Store store, OnStoreSelectedListener onStoreSelectedListener) {
            this.binding.setViewModel(viewModel);
            this.binding.setOnStoreSelected(onStoreSelectedListener);
            this.binding.setStore(store);
            this.binding.executePendingBindings();
        }
    }

    public interface OnStoreSelectedListener {
        void onStoreSelected(Store store);
    }
}
