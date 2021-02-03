package com.tyagiabhinav.restaurantapp.view.restaurantdetail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.databinding.ItemMenuBinding;
import com.tyagiabhinav.restaurantapp.model.pojo.PopularItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PopularMenuItemAdapter extends RecyclerView.Adapter<PopularMenuItemAdapter.PopularItemViewHolder> {

    List<PopularItem> popItemList;

    public PopularMenuItemAdapter(List<PopularItem> popItems) {
        this.popItemList = popItems;
    }

    @NonNull
    @Override
    public PopularItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMenuBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_menu, parent, false);
        return new PopularMenuItemAdapter.PopularItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularItemViewHolder holder, int position) {
        holder.bind(popItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return popItemList != null ? popItemList.size() : 0;
    }

    class PopularItemViewHolder extends RecyclerView.ViewHolder {

        ItemMenuBinding binding;

        public PopularItemViewHolder(@NonNull ItemMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PopularItem popItem) {
//            Picasso.get().load(store.getCoverImgUrl()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(this.binding.logo);
            this.binding.setPopItem(popItem);
            this.binding.executePendingBindings();
        }
    }
}
