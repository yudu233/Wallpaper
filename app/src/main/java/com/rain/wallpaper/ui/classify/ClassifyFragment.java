package com.rain.wallpaper.ui.classify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.rain.api.UrlCollection;
import com.rain.api.data.ClassifyInfo;
import com.rain.sdk.ListResource;
import com.rain.sdk.base.BaseViewModel;
import com.rain.sdk.base.fragment.BaseInjectFragment;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.FragmentClassifyBinding;
import com.rain.wallpaper.ui.PhotoListActivity;
import com.rain.wallpaper.ui.adapter.ClassifyAdapter;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyFragment
 * @CreateDate: 2020/8/13 21:55
 * @Describe:
 */
@AndroidEntryPoint
public class ClassifyFragment extends BaseInjectFragment<FragmentClassifyBinding> {

    private int[] coverImages = {
            R.mipmap.cover_work,
            R.mipmap.cover_technology,
            R.mipmap.cover_wallpaper,
            R.mipmap.cover_travel,
            R.mipmap.cover_nature,
            R.mipmap.cover_film,
            R.mipmap.cover_textures,
            R.mipmap.cover_current_events,
            R.mipmap.cover_people,
            R.mipmap.cover_business_work,
            R.mipmap.cover_covid19,
            R.mipmap.cover_animals,
            R.mipmap.cover_interiorsk,
            R.mipmap.cover_architecture,
            R.mipmap.cover_food,
            R.mipmap.cover_athletics,
            R.mipmap.cover_spirituality,
            R.mipmap.cover_health,
            R.mipmap.cover_fashion,
            R.mipmap.cover_experimental,
            R.mipmap.cover_art_culture,
            R.mipmap.cover_history,
            R.mipmap.cover_street_photography
    };

    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initView() {

        ClassifyViewModel classifyViewModel = new ViewModelProvider(this).get(ClassifyViewModel.class);
        classifyViewModel.init(ListResource.refreshing(0, 30));



        ClassifyAdapter mClassifyAdapter = new ClassifyAdapter(R.layout.item_classify);

//        String[] classifyTitles = getResources().getStringArray(R.array.cover_images_title_CN);
//
//        Observable.range(0, coverImages.length)
//                .observeOn(Schedulers.io())
//                .concatMap((Function<Integer, ObservableSource<ClassifyEntity>>) integer ->
//                        Observable.just(new ClassifyEntity(classifyTitles[integer], coverImages[integer])))
//                .toList()
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(mClassifyAdapter::setNewInstance);

        binding.recyclerView.setAdapter(mClassifyAdapter);




        mClassifyAdapter.setEmptyView(R.layout.layout_loading);

        classifyViewModel.observeListResource(this, viewModel -> {
                    ListResource.State state = viewModel.getListState();
                    if (state == ListResource.State.REFRESHING || state == ListResource.State.LOADING &&
                            viewModel.getListSize() == 0) return;

                    if (state == ListResource.State.ERROR) {
                        mClassifyAdapter.setEmptyView(R.layout.layout_error);
                    }



                    viewModel.readDataList(new BaseViewModel.DataListReader<ClassifyInfo>() {
                        @Override
                        public void execute(List<ClassifyInfo> list) {
                            mClassifyAdapter.setList(list);
                        }
                    });
                });




        mClassifyAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getContext(), PhotoListActivity.class);
                        intent.putExtra("classify", UrlCollection.CATEGORIES_FASHION);
                        startActivity(intent);
                        break;
                    case 1:
                        break;
                }
            }
        });

    }

}
