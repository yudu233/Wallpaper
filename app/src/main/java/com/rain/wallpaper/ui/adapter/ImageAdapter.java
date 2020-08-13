package com.rain.wallpaper.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.wallpaper.entity.ImageInfo;

import java.util.List;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ImageAdapter
 * @CreateDate: 2020/7/4 10:44
 * @Describe:
 */
public class ImageAdapter extends BaseQuickAdapter<ImageInfo, BaseViewHolder> {
    public ImageAdapter(@Nullable List<ImageInfo> data) {
        super(data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ImageInfo item) {

    }
}
