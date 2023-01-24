package com.example.srez.ui.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtils {

    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
