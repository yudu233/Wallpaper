package com.rain.api.data;

import android.util.Log;

import androidx.annotation.Size;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: Photo
 * @CreateDate: 2020/9/9 22:19
 * @Describe: 转换后的图片信息
 */
public class Photo {
    public String photoUrl;
    public String thumbUrl;
    public @Size
    int[] photoSize;

    public Photo(ImageInfo imageInfo) {
        this.photoUrl = imageInfo.getUrls().getRegular()
                .replace("https://images.unsplash.com/", "http://unsplash.nesnode.com/");
        this.thumbUrl = imageInfo.getUrls().getThumb()
                .replace("https://images.unsplash.com/", "http://unsplash.nesnode.com/");
        this.photoSize = new int[]{
                ScreenUtils.getScreenWidth(),(int)((float)ScreenUtils.getScreenWidth() / imageInfo.getWidth() * imageInfo.getHeight())
        };
    }
}
