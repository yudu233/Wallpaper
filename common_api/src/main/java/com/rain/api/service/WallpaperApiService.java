package com.rain.api.service;

import com.rain.api.UrlCollection;
import com.rain.api.data.ImageInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: RecommendService
 * @CreateDate: 2020/9/12 13:53
 * @Describe:
 */
public interface WallpaperApiService {

    /**
     * get recommend photos
     *
     * @param page     page number
     * @param per_page count
     * @return
     */
    @GET(UrlCollection.RECOMMEND_PHOTOS)
    Observable<List<ImageInfo>> getRecommendPhotos(@Query("page") int page,
                                                   @Query("per_page") int per_page);

}
