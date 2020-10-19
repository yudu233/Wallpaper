package com.rain.wallpaper.ui.adapter;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.rain.api.data.ClassifyInfo;
import com.rain.sdk.image.CoverImageView;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.ItemClassifyBinding;

import org.jetbrains.annotations.NotNull;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyAdapter
 * @CreateDate: 2020/9/27 21:04
 * @Describe:
 */
public class ClassifyAdapter extends BaseQuickAdapter<ClassifyInfo, BaseDataBindingHolder<ItemClassifyBinding>> {
    public ClassifyAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void onItemViewHolderCreated(@NotNull BaseDataBindingHolder<ItemClassifyBinding> viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemClassifyBinding> helper, ClassifyInfo data) {
        // 获取 Binding
        ItemClassifyBinding dataBinding = helper.getDataBinding();
        dataBinding.setData(data);
        dataBinding.setIsOpen(data.getStatus().equals("open"));
        String totalPhotos = String.format(getContext().getString(R.string.text_classify_count), data.getTotal_photos() / 1000f);
        dataBinding.setTotalPhotos(totalPhotos);

        CoverImageView coverImageView = helper.findView(R.id.imv_classify_cover);
        coverImageView.setSize(1080, 300);
        String  coverPhotoUrl = data.getCover_photo().getUrls().getRaw() + "&w=438&h=136.875&fit=crop";
        dataBinding.setCoverUrl(coverPhotoUrl);
    }
}
