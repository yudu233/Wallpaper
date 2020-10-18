package com.rain.wallpaper.ui.classify;

import com.rain.api.data.ClassifyInfo;
import com.rain.api.service.WallpaperApiService;
import com.rain.sdk.ListResource;
import com.rain.sdk.base.BaseRepository;
import com.rain.sdk.network.rxWeaver.CustomerSubscriber;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyRepository
 * @CreateDate: 2020/10/18 22:25
 * @Describe:
 */
@Singleton
public class ClassifyRepository extends BaseRepository {
    @Inject
    Retrofit retrofit;

    @Inject
    public ClassifyRepository() {
    }

    public void getClassifyList(ClassifyViewModel viewModel){
        retrofit.create(WallpaperApiService.class)
                .getClassifyList(viewModel.getListRequestPage(), viewModel.getListPerPage())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomerSubscriber<List<ClassifyInfo>>(false) {
                    @Override
                    protected void onSuccess(List<ClassifyInfo> data) {
                        viewModel.writeDataSource(resource -> ListResource.loadSuccessNot(resource,data));
                    }
                });
    }
}
