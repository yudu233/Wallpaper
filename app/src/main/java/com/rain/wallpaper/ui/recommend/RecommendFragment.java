package com.rain.wallpaper.ui.recommend;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.rain.api.data.Photo;
import com.rain.sdk.ListResource;
import com.rain.sdk.PhotoListPager;
import com.rain.sdk.base.fragment.BaseInjectFragment;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.FragmentRecommendBinding;
import com.rain.wallpaper.ui.adapter.ImageAdapter;

import java.util.List;

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
        binding.smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            recommendViewMode.refresh();
            binding.smartRefreshLayout.finishRefresh();
        });
        binding.smartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            recommendViewMode.load();
            binding.smartRefreshLayout.finishLoadMore();
        });

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int loadingPosition = 0;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int itemCount = layoutManager.getItemCount();
                int lastPosition = layoutManager.findLastCompletelyVisibleItemPosition();

                LogUtils.e(lastPosition + "---" + itemCount + "---" + loadingPosition);
                if (lastPosition == itemCount - 5 && loadingPosition != lastPosition) {
                    loadingPosition = itemCount - 5;
                    recommendViewMode.load();
                }
            }
        });
        imageAdapter.setEmptyView(R.layout.layout_loading);

//        imageAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
////            ListResource.State state = recommendViewMode.getListState();
////            LogUtils.e("loadMore" + state);
//            recommendViewMode.load();
//
////            if ( state != ListResource.State.LOADING){
////                LogUtils.e("loadMore");
////                recommendViewMode.load();
////            }
//        });
//        imageAdapter.getLoadMoreModule().setAutoLoadMore(true);
//        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
//        imageAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
//        imageAdapter.getLoadMoreModule().setPreLoadNumber(5);
//        recommendViewMode.init(ListResource.refreshing(0, PhotoListPager.DEFAULT_PER_PAGE));
        recommendViewMode.observeListResource(this, viewModel -> {
            ListResource.State state = viewModel.getListState();
            if (state == ListResource.State.REFRESHING || state == ListResource.State.LOADING &&
                    viewModel.getListSize() == 0) return;
            viewModel.readDataList(list -> {
                if (list.size() < PhotoListPager.DEFAULT_PER_PAGE) {
                    imageAdapter.getLoadMoreModule().loadMoreEnd();
                } else {
                    imageAdapter.getLoadMoreModule().loadMoreComplete();
                }
                if (imageAdapter.getData().size() == 0) {
                    imageAdapter.setList(list);
                } else {

                    imageAdapter.addData(list);
                }

            });
        });

        recommendViewMode.data.observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {

                if (photos.size() < 10) {
                    imageAdapter.getLoadMoreModule().loadMoreEnd();
                } else {
                    imageAdapter.getLoadMoreModule().loadMoreComplete();

                }
                if (imageAdapter.getData().size() == 0) {
                    imageAdapter.setList(photos);
                } else {

                    imageAdapter.addData(photos);
                }
                imageAdapter.getLoadMoreModule().setEnableLoadMore(true);

            }
        });
    }
}
