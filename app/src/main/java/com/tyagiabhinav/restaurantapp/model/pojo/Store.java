
package com.tyagiabhinav.restaurantapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Store {

    @SerializedName("is_consumer_subscription_eligible")
    @Expose
    private boolean isConsumerSubscriptionEligible;
    @SerializedName("promotion_delivery_fee")
    @Expose
    private int promotionDeliveryFee;
    @SerializedName("delivery_fee")
    @Expose
    private int deliveryFee;
    @SerializedName("delivery_fee_monetary_fields")
    @Expose
    private DeliveryFeeMonetaryFields deliveryFeeMonetaryFields;
    @SerializedName("num_ratings")
    @Expose
    private int numRatings;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("extra_sos_delivery_fee_monetary_fields")
    @Expose
    private ExtraSosDeliveryFeeMonetaryFields extraSosDeliveryFeeMonetaryFields;
    @SerializedName("menus")
    @Expose
    private List<Menu> menus = null;
    @SerializedName("average_rating")
    @Expose
    private float averageRating;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("display_delivery_fee")
    @Expose
    private String displayDeliveryFee;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("business_id")
    @Expose
    private int businessId;
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    private int extraSosDeliveryFee;
    @SerializedName("cover_img_url")
    @Expose
    private String coverImgUrl;
    @SerializedName("header_img_url")
    @Expose
    private String headerImgUrl;
    @SerializedName("price_range")
    @Expose
    private int priceRange;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_newly_added")
    @Expose
    private boolean isNewlyAdded;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("next_close_time")
    @Expose
    private String nextCloseTime;
    @SerializedName("next_open_time")
    @Expose
    private String nextOpenTime;
    @SerializedName("service_rate")
    @Expose
    private Object serviceRate;
    @SerializedName("distance_from_consumer")
    @Expose
    private float distanceFromConsumer;
    @SerializedName("merchant_promotions")
    @Expose
    private List<MerchantPromotion> merchantPromotions = null;

    public boolean isIsConsumerSubscriptionEligible() {
        return isConsumerSubscriptionEligible;
    }

    public void setIsConsumerSubscriptionEligible(boolean isConsumerSubscriptionEligible) {
        this.isConsumerSubscriptionEligible = isConsumerSubscriptionEligible;
    }

    public int getPromotionDeliveryFee() {
        return promotionDeliveryFee;
    }

    public void setPromotionDeliveryFee(int promotionDeliveryFee) {
        this.promotionDeliveryFee = promotionDeliveryFee;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public DeliveryFeeMonetaryFields getDeliveryFeeMonetaryFields() {
        return deliveryFeeMonetaryFields;
    }

    public void setDeliveryFeeMonetaryFields(DeliveryFeeMonetaryFields deliveryFeeMonetaryFields) {
        this.deliveryFeeMonetaryFields = deliveryFeeMonetaryFields;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExtraSosDeliveryFeeMonetaryFields getExtraSosDeliveryFeeMonetaryFields() {
        return extraSosDeliveryFeeMonetaryFields;
    }

    public void setExtraSosDeliveryFeeMonetaryFields(ExtraSosDeliveryFeeMonetaryFields extraSosDeliveryFeeMonetaryFields) {
        this.extraSosDeliveryFeeMonetaryFields = extraSosDeliveryFeeMonetaryFields;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDisplayDeliveryFee() {
        return displayDeliveryFee;
    }

    public void setDisplayDeliveryFee(String displayDeliveryFee) {
        this.displayDeliveryFee = displayDeliveryFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getExtraSosDeliveryFee() {
        return extraSosDeliveryFee;
    }

    public void setExtraSosDeliveryFee(int extraSosDeliveryFee) {
        this.extraSosDeliveryFee = extraSosDeliveryFee;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getHeaderImgUrl() {
        return headerImgUrl;
    }

    public void setHeaderImgUrl(String headerImgUrl) {
        this.headerImgUrl = headerImgUrl;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsNewlyAdded() {
        return isNewlyAdded;
    }

    public void setIsNewlyAdded(boolean isNewlyAdded) {
        this.isNewlyAdded = isNewlyAdded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNextCloseTime() {
        return nextCloseTime;
    }

    public void setNextCloseTime(String nextCloseTime) {
        this.nextCloseTime = nextCloseTime;
    }

    public String getNextOpenTime() {
        return nextOpenTime;
    }

    public void setNextOpenTime(String nextOpenTime) {
        this.nextOpenTime = nextOpenTime;
    }

    public Object getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Object serviceRate) {
        this.serviceRate = serviceRate;
    }

    public float getDistanceFromConsumer() {
        return distanceFromConsumer;
    }

    public void setDistanceFromConsumer(float distanceFromConsumer) {
        this.distanceFromConsumer = distanceFromConsumer;
    }

    public List<MerchantPromotion> getMerchantPromotions() {
        return merchantPromotions;
    }

    public void setMerchantPromotions(List<MerchantPromotion> merchantPromotions) {
        this.merchantPromotions = merchantPromotions;
    }
}
