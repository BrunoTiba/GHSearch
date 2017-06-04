package com.bkenji.ghsearch.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Bruno Tiba on 03/06/2017.
 */

public class ImageBinder {

    private ImageBinder() {
        // Private constructor to prevent instantiation
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
