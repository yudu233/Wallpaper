package com.rain.wallpaper.ui.fragment;

import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.FragmentRecommendBinding;
import com.rain.wallpaper.repository.RecommendRepository;
import com.rain.wallpaper.ui.Entity;
import com.rain.wallpaper.viewmodel.RecommendViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.scopes.FragmentScoped;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: MainFragment
 * @CreateDate: 2020/8/13 21:54
 * @Describe:
 */
@AndroidEntryPoint
public class RecommendFragment extends BaseInjectFragment<FragmentRecommendBinding> {

    @FragmentScoped
    @Inject
    RecommendRepository repository;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        RecommendViewModel viewModel = new ViewModelProvider(this).get(RecommendViewModel.class);
        //viewModel.getData();
        repository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Entity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Entity entity) {
                       // data.postValue(entity);
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
