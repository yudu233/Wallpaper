package com.rain.wallpaper.ui.fragment;

import com.rain.sdk.base.fragment.BaseInjectFragment;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.FragmentClassifyBinding;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyFragment
 * @CreateDate: 2020/8/13 21:55
 * @Describe:
 */
public class ClassifyFragment extends BaseInjectFragment<FragmentClassifyBinding> {
    public static ClassifyFragment newInstance() {
        return new ClassifyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initView() {

    }
}
