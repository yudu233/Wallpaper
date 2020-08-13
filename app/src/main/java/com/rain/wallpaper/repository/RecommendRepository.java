package com.rain.wallpaper.repository;

import com.rain.wallpaper.api.WallpaperApiService;
import com.rain.wallpaper.ui.Entity;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: RecommendRepository
 * @CreateDate: 2020/8/13 23:45
 * @Describe:
 */
public class RecommendRepository {
    @Inject
    Retrofit retrofit;



    public Observable<Entity> getData(){
        return retrofit.create(WallpaperApiService.class).getTest();
    }

}
