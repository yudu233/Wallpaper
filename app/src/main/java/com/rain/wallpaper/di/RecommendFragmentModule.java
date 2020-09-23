package com.rain.wallpaper.di;

import com.rain.api.data.Photo;
import com.rain.wallpaper.R;
import com.rain.wallpaper.ui.recommend.RecommendRepository;
import com.rain.wallpaper.ui.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: FragmentModule
 * @CreateDate: 2020/8/14 0:11
 * @Describe:
 */
@Module
@InstallIn(FragmentComponent.class)
public class RecommendFragmentModule {
    @FragmentScoped
    @Provides
    RecommendRepository provideRecommendRepository(){
        return new RecommendRepository();
    }

    @FragmentScoped
    @Provides
    ImageAdapter provideImageAdapter(List<Photo> data){
        return new ImageAdapter(data, R.layout.item_image);
    }

    @FragmentScoped
    @Provides
    List<Photo> provideImageInfo(){
        return new ArrayList<>();
    }
}
