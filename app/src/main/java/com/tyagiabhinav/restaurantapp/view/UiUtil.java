package com.tyagiabhinav.restaurantapp.view;

import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tyagiabhinav.restaurantapp.R;

import androidx.databinding.BindingAdapter;

public class UiUtil {

    /**
     * set image via picasso to an image view
     *
     * @param imageView
     * @param imageUrl
     */
    @BindingAdapter({"imageUrl"})
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
}
