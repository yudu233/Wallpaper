package com.rain.wallpaper.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: AppModule
 * @CreateDate: 2020/8/12 23:15
 * @Describe:
 */
@InstallIn(ApplicationComponent.class)
@Module
public abstract class AppModule {

    @Singleton
    @Provides
    static Gson provideGson(){
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls().enableComplexMapKeySerialization();
        return builder.create();
    }
}
