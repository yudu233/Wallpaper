package com.rain.wallpaper.di;

import com.rain.wallpaper.repository.RecommendRepository;

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
public class FragmentModule {
    @FragmentScoped
    @Provides
    RecommendRepository provideRecommendRepository(){
        return new RecommendRepository();
    }
}
