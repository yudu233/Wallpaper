package com.rain.wallpaper.app;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: WapperApplication
 * @CreateDate: 2020/7/4 10:48
 * @Describe:
 */
@HiltAndroidApp
public class WallpaperApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
