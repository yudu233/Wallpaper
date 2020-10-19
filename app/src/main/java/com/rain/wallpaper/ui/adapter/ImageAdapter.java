package com.rain.wallpaper.ui.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.api.data.Photo;
import com.rain.sdk.image.CoverImageView;
import com.rain.sdk.image.ImageUtils;
import com.rain.wallpaper.R;

import java.util.List;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ImageAdapter
 * @CreateDate: 2020/7/4 10:44
 * @Describe:
 */
public class ImageAdapter extends BaseQuickAdapter<Photo, BaseViewHolder> implements LoadMoreModule {
    public ImageAdapter(@Nullable List<Photo> data, int redId) {
        super(redId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Photo data) {

        helper.itemView.findViewById(R.id.parentView).setBackgroundColor(Color.parseColor(data.color));
        CoverImageView imageView = helper.itemView.findViewById(R.id.imageView);
        imageView.setSize(data.photoSize[0], data.photoSize[1]);
        ImageUtils.setImageViewSaturation(imageView, false ? 1 : 0);
        int[] thumbSize = new int[]{Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL};
        RequestBuilder<Drawable> thumb = TextUtils.isEmpty(data.thumbUrl) ? null : Glide.with(getContext())
                .load(data.thumbUrl)

                .override(thumbSize[0], thumbSize[1]).diskCacheStrategy(
                        DiskCacheStrategy.NONE
                ).listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        imageView.setTag(R.id.tag_item_image_fade_in_flag, false);

                        return false;
                    }
                });
        imageView.setTag(R.id.tag_item_image_fade_in_flag, true);

        Log.e("Rain",data.photoUrl);
        Glide.with(imageView)
                .load(data.photoUrl)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .override(data.photoSize[0], data.photoSize[1])
                .thumbnail(thumb)
                .into(imageView);

        ImageUtils.startSaturationAnimation(getContext(), imageView);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
