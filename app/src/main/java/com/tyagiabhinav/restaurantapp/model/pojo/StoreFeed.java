
package com.tyagiabhinav.restaurantapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoreFeed {

    @SerializedName("num_results")
    @Expose
    private int numResults;
    @SerializedName("is_first_time_user")
    @Expose
    private boolean isFirstTimeUser;
    @SerializedName("sort_order")
    @Expose
    private String sortOrder;
    @SerializedName("next_offset")
    @Expose
    private int nextOffset;
    @SerializedName("show_list_as_pickup")
    @Expose
    private boolean showListAsPickup;
    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public boolean isIsFirstTimeUser() {
        return isFirstTimeUser;
    }

    public void setIsFirstTimeUser(boolean isFirstTimeUser) {
        this.isFirstTimeUser = isFirstTimeUser;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int nextOffset) {
        this.nextOffset = nextOffset;
    }

    public boolean isShowListAsPickup() {
        return showListAsPickup;
    }

    public void setShowListAsPickup(boolean showListAsPickup) {
        this.showListAsPickup = showListAsPickup;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

}
