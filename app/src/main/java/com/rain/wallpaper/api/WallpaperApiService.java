package com.rain.wallpaper.api;

import com.rain.wallpaper.ui.Entity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: WallpaperApiService
 * @CreateDate: 2020/7/4 14:04
 * @Describe:
 */
public interface WallpaperApiService {


    @GET("history/api.php?num=10&format=json")
    Observable<Entity> getTest();

}
