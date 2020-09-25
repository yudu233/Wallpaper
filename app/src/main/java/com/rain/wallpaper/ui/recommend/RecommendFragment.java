package com.rain.wallpaper.ui.recommend;

import androidx.lifecycle.ViewModelProvider;

import com.blankj.utilcode.util.LogUtils;
import com.rain.sdk.ListResource;
import com.rain.sdk.PhotoListPager;
import com.rain.sdk.base.fragment.BaseInjectFragment;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.FragmentRecommendBinding;
import com.rain.wallpaper.ui.adapter.ImageAdapter;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

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

    @Inject
    ImageAdapter imageAdapter;

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        binding.recyclerView.setAdapter(imageAdapter);

        RecommendViewModel recommendViewMode = new ViewModelProvider(this).get(RecommendViewModel.class);
        binding.setViewModel(recommendViewMode);


        imageAdapter.setEmptyView(R.layout.layout_loading);
        imageAdapter.getLoadMoreModule().setAutoLoadMore(true);
        imageAdapter.getLoadMoreModule().setEnableLoadMore(false);
        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        //imageAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        imageAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
            LogUtils.e("viewmode","viewmode ============ "+recommendViewMode.getListRequestPage());

            recommendViewMode.load();
        });


        recommendViewMode.init(ListResource.refreshing(0, PhotoListPager.DEFAULT_PER_PAGE));
        recommendViewMode.observeListResource(this, viewModel -> {

            ListResource.State state = viewModel.getListState();
            imageAdapter.getLoadMoreModule().setEnableLoadMore(true);
            LogUtils.e(state);
            if (state == ListResource.State.REFRESHING || state == ListResource.State.LOADING &&
                    viewModel.getListSize() == 0) return;
            viewModel.readDataList(list -> {
                if (list.size() <10)
                    imageAdapter.getLoadMoreModule().loadMoreEnd();
                else
                    imageAdapter.getLoadMoreModule().loadMoreComplete();
                LogUtils.e("observeListResource : " + list.size());
              /* if (viewModel.getListRequestPage() == 1)*/ imageAdapter.addData(list);


            });
        });
    }
}
