package com.rain.wallpaper.ui.recommend;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private int loadingPosition = 0;

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
        if (getArguments() != null){
            String classify = getArguments().getString("classify");
            recommendViewMode.setClassify(classify);
        }
        recommendViewMode.init(ListResource.refreshing(0, PhotoListPager.DEFAULT_PER_PAGE));

        binding.smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            loadingPosition = 0;
            imageAdapter.getData().clear();
            recommendViewMode.refresh();
            binding.smartRefreshLayout.finishRefresh();
        });
        binding.smartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            if (recommendViewMode.getListState() != ListResource.State.LOADING){
                recommendViewMode.load();
            }
            binding.smartRefreshLayout.finishLoadMore();
        });

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int itemCount = layoutManager.getItemCount();
                int lastPosition = layoutManager.findLastCompletelyVisibleItemPosition();

                if (lastPosition == itemCount - 5 && loadingPosition != lastPosition) {
                    loadingPosition = itemCount - 5;
                    recommendViewMode.load();
                }
            }
        });
        imageAdapter.setEmptyView(R.layout.layout_loading);

        recommendViewMode.observeListResource(this, viewModel -> {
            ListResource.State state = viewModel.getListState();
            if (state == ListResource.State.REFRESHING || state == ListResource.State.LOADING &&
                    viewModel.getListSize() == 0) return;

            if (state == ListResource.State.ERROR) {
                if (viewModel.getListSize() == 0) {
                    imageAdapter.setEmptyView(R.layout.layout_error);
                } else {
                    binding.smartRefreshLayout.finishLoadMore(false);
                }
            }
            viewModel.readDataList(list -> binding.recyclerView.post(() -> {
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
            }));
        });
    }
}
