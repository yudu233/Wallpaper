package com.rain.wallpaper.ui.classify;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;

import com.rain.api.data.ClassifyInfo;
import com.rain.sdk.ListResource;
import com.rain.sdk.base.BaseViewModel;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyViewModel
 * @CreateDate: 2020/10/18 22:25
 * @Describe:
 */
public class ClassifyViewModel extends BaseViewModel<ClassifyInfo> {

    private ClassifyRepository repository;
    private SavedStateHandle savedStateHandle;

    @ViewModelInject
    public ClassifyViewModel(@Assisted SavedStateHandle handle, ClassifyRepository repository) {
        this.repository = repository;
        this.savedStateHandle = handle;
    }

    @Override
    protected boolean init(@NonNull ListResource<ClassifyInfo> resource) {
        if (super.init(resource)) {
            load();
            return true;
        }
        return false;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void load() {
        writeDataSource(ListResource::loading);
        repository.getClassifyList(this);
    }
}
