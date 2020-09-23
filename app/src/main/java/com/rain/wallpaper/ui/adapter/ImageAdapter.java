package com.rain.wallpaper.ui.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.api.data.Photo;
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
        super(redId,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Photo data) {

        AppCompatImageView imageView = helper.itemView.findViewById(R.id.imageView);

        RequestBuilder<Drawable> thumb =  TextUtils.isEmpty(data.thumbUrl) ? null : Glide.with(getContext())
                .load(data.thumbUrl)
                .override(data.photoSize[0], data.photoSize[1]);

        ImageUtils.setImageViewSaturation(imageView, false ? 1 : 0);

        Glide.with(imageView)
                .load(data.photoUrl)
                .thumbnail(thumb)
                .override(data.photoSize[0], data.photoSize[1])
                .into(imageView);

        ImageUtils.startSaturationAnimation(getContext(), imageView);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
