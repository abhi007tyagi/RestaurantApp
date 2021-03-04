package com.tyagiabhinav.restaurantapp.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tyagiabhinav.restaurantapp.R;
import com.tyagiabhinav.restaurantapp.model.SharedPrefManager;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseMethod;

public class UiUtil {

    /**
     * set image via picasso to an image view
     *
     * @param imageView
     * @param imageUrl
     */
    @BindingAdapter("imageUrl")
    public static void loadimage(ImageView imageView, String imageUrl){
        Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(imageView);
    }

    /**
     * to hide unhide a view like progress bar
     *
     * @param target
     * @param visibility
     */
    @BindingAdapter("android:animatedVisibility")
    public static void  setAnimatedVisibility(View target, boolean visibility) {
        if (visibility) {
            target.setVisibility(View.VISIBLE);
        } else {
            target.setVisibility(View.GONE);
        }
    }

//    @InverseMethod("setIsLike")
//    public static void setIsLike(ImageView imageView, int id) {
//        Context context  = imageView.getContext();
//        boolean isLiked = SharedPrefManager.getLikeForStoreById(context, String.valueOf(id));
//        SharedPrefManager.setLikeForStoreById(context, String.valueOf(id), !isLiked);
//    }
//
//    @BindingAdapter("isLiked")
//    public static void isLike(ImageView imageView, int id){
//        Context context  = imageView.getContext();
//        boolean isLiked = SharedPrefManager.getLikeForStoreById(context, String.valueOf(id));
//        if(isLiked)
//            imageView.setImageResource(R.drawable.ic_liked);
//        else
//            imageView.setImageResource(R.drawable.ic_like_24);
//    }

//    @InverseBindingAdapter(attribute = "isLiked")
//    public static boolean getIsLike(ImageView imageView) {
//        return imageView.isLiked();
//    }
}
