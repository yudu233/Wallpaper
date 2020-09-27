package com.rain.wallpaper.ui.recommend;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.blankj.utilcode.util.LogUtils;
import com.rain.api.data.Photo;
import com.rain.sdk.ListResource;
import com.rain.sdk.base.BaseViewModel;

import java.util.List;

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

    @ViewModelInject
    public RecommendViewModel(@Assisted SavedStateHandle handle, RecommendRepository repository) {
        this.repository = repository;
        this.savedStateHandle = handle;
    }

    @Override
    protected boolean init(@NonNull ListResource<Photo> resource) {

        if (super.init(resource)) {
            LogUtils.e("init : page = " + getListRequestPage());
            load();
            return true;
        }
        return false;
    }

    @Override
    public void refresh() {
        writeDataSource(ListResource::refreshing);
        repository.getRecommendPhotos(this, true);
    }

    @Override
    public void load() {
        writeDataSource(ListResource::loading);
        repository.getRecommendPhotos(this, false);
    }
}
