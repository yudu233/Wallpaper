package com.rain.wallpaper.app;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;

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

        LogUtils.Config logConfig = LogUtils.getConfig();
        logConfig.setLogHeadSwitch(false);
        logConfig.setBorderSwitch(false);
    }
}
