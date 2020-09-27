package com.rain.wallpaper.ui.adapter;

import android.view.ViewGroup;

import androidx.cardview.widget.CardView;

import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.api.data.ClassifyEntity;
import com.rain.wallpaper.R;

import org.jetbrains.annotations.NotNull;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyAdapter
 * @CreateDate: 2020/9/27 21:04
 * @Describe:
 */
public class ClassifyAdapter extends BaseQuickAdapter<ClassifyEntity, BaseViewHolder> {
    public ClassifyAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, ClassifyEntity data) {
        CardView cardView = helper.itemView.findViewById(R.id.cardView);
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        layoutParams.height = ScreenUtils.getScreenWidth() / 2 ;

        helper.setImageResource(R.id.imv_cover,data.classifyResId);
        helper.setText(R.id.txv_coverTitle,data.classifyTitle);
    }
}
