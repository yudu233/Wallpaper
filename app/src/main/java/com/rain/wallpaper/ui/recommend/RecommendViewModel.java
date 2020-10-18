package com.rain.wallpaper.ui.recommend;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;

import com.rain.api.data.Photo;
import com.rain.sdk.ListResource;
import com.rain.sdk.base.BaseViewModel;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: RecommendViewModel
 * @CreateDate: 2020/8/13 23:33
 * @Describe:
 */

public class RecommendViewModel extends BaseViewModel<Photo> {

    private RecommendRepository repository;
    private SavedStateHandle savedStateHandle;
    private String classify = "";

    @ViewModelInject
    public RecommendViewModel(@Assisted SavedStateHandle handle, RecommendRepository repository) {
        this.repository = repository;
        this.savedStateHandle = handle;
    }

    @Override
    protected boolean init(@NonNull ListResource<Photo> resource) {
        if (super.init(resource)) {
            load();
            return true;
        }
        return false;
    }

    @Override
    public void refresh() {
        writeDataSource(ListResource::refreshing);
        repository.getRecommendPhotos(this, classify, true);
    }

    @Override
    public void load() {
        writeDataSource(ListResource::loading);
        repository.getRecommendPhotos(this, classify, false);
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
