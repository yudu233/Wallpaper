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

        recommendViewMode.init(ListResource.refreshing(0, PhotoListPager.DEFAULT_PER_PAGE));
        recommendViewMode.observeListResource(this, viewModel -> {
            ListResource.State state = viewModel.getListState();
            LogUtils.e(state);
            if (state == ListResource.State.REFRESHING || state == ListResource.State.LOADING &&
                    viewModel.getListSize() == 0) return;
            viewModel.readDataList(list -> {
                LogUtils.e("observeListResource : " + list.size());
                imageAdapter.setList(list);
            });
        });
        imageAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
            LogUtils.e("loadMore");
            recommendViewMode.load();
            imageAdapter.getLoadMoreModule().loadMoreEnd();
        });
    }
}
