package com.rain.wallpaper.ui.recommend;

import com.blankj.utilcode.util.LogUtils;
import com.rain.api.data.ImageInfo;
import com.rain.api.data.Photo;
import com.rain.api.service.WallpaperApiService;
import com.rain.sdk.ListResource;
import com.rain.sdk.network.rxWeaver.CustomerSubscriber;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: RecommendRepository
 * @CreateDate: 2020/8/13 23:45
 * @Describe:
 */
@Singleton
public class RecommendRepository {
    @Inject
    Retrofit retrofit;

    @Inject
    public RecommendRepository() {
    }

    public void getRecommendPhotos(RecommendViewModel viewModel, boolean isRefresh) {
        LogUtils.e("getRecommendPhotos : page = " + viewModel.getListRequestPage());
        retrofit.create(WallpaperApiService.class)
                .getRecommendPhotos(viewModel.getListRequestPage(), viewModel.getListPerPage())
                .subscribeOn(Schedulers.io())
                .flatMapSingle((Function<List<ImageInfo>, SingleSource<List<Photo>>>) imageInfos ->
                        Observable.fromIterable(imageInfos)
                                .flatMap((Function<ImageInfo, ObservableSource<Photo>>) imageInfo -> {
                                    Photo photo = new Photo(imageInfo);
                                    return Observable.just(photo);
                                }).toList())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomerSubscriber<List<Photo>>(false) {
                    @Override
                    protected void onSuccess(List<Photo> response) {
                        if (isRefresh) {
                            viewModel.writeDataSource(resource -> ListResource.refreshSuccess(resource, response));
                        } else {
                            viewModel.writeDataSource(resource -> ListResource.loadSuccessNot(resource, response));
                        }
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        super.onError(e);
                        viewModel.writeDataSource(resource -> ListResource.error(resource));
                    }
                });
    }
}
