package com.rain.sdk.databiding;

import android.graphics.Bitmap;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ImageViewAdapter
 * @CreateDate: 2020/10/19 21:54
 * @Describe:
 */
public class ImageViewAdapter {
    @BindingAdapter("android:src")
    public static void setSrc(AppCompatImageView imageView, Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(AppCompatImageView imageView, int resId){
        imageView.setImageResource(resId);
    }

    @BindingAdapter("imageUrl")
    public static void setSrc(AppCompatImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url)
                .into(imageView);
    }


    @BindingAdapter({"app:imageUrl", "app:placeHolder", "app:error"})
    public static void loadImage(AppCompatImageView imageView, String url, int holderDrawable, int errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView);
    }

}
