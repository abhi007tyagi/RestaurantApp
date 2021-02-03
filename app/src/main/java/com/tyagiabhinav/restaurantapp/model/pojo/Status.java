
package com.tyagiabhinav.restaurantapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Status {

    @SerializedName("unavailable_reason")
    @Expose
    private Object unavailableReason;
    @SerializedName("pickup_available")
    @Expose
    private boolean pickupAvailable;
    @SerializedName("asap_available")
    @Expose
    private boolean asapAvailable;
    @SerializedName("scheduled_available")
    @Expose
    private boolean scheduledAvailable;
    @SerializedName("asap_minutes_range")
    @Expose
    private List<Integer> asapMinutesRange = null;

    public Object getUnavailableReason() {
        return unavailableReason;
    }

    public void setUnavailableReason(Object unavailableReason) {
        this.unavailableReason = unavailableReason;
    }

    public boolean isPickupAvailable() {
        return pickupAvailable;
    }

    public void setPickupAvailable(boolean pickupAvailable) {
        this.pickupAvailable = pickupAvailable;
    }

    public boolean isAsapAvailable() {
        return asapAvailable;
    }

    public void setAsapAvailable(boolean asapAvailable) {
        this.asapAvailable = asapAvailable;
    }

    public boolean isScheduledAvailable() {
        return scheduledAvailable;
    }

    public void setScheduledAvailable(boolean scheduledAvailable) {
        this.scheduledAvailable = scheduledAvailable;
    }

    public List<Integer> getAsapMinutesRange() {
        return asapMinutesRange;
    }

    public void setAsapMinutesRange(List<Integer> asapMinutesRange) {
        this.asapMinutesRange = asapMinutesRange;
    }

}
