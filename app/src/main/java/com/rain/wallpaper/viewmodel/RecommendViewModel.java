package com.rain.wallpaper.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rain.wallpaper.repository.RecommendRepository;
import com.rain.wallpaper.ui.Entity;

import javax.inject.Inject;

import dagger.hilt.android.scopes.FragmentScoped;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: RecommendViewModel
 * @CreateDate: 2020/8/13 23:33
 * @Describe:
 */
public class RecommendViewModel extends ViewModel  {
    @FragmentScoped
    @Inject
    RecommendRepository repository;

    private MutableLiveData data = new MutableLiveData<Entity>();



    public void getData(){
        repository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Entity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Entity entity) {
                        data.postValue(entity);
                        Log.e("Rain",entity.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
