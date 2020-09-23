package com.rain.wallpaper.ui.fragment;

import com.rain.sdk.base.fragment.BaseInjectFragment;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.FragmentMineBinding;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: MineFragment
 * @CreateDate: 2020/8/13 21:56
 * @Describe:
 */
public class MineFragment extends BaseInjectFragment<FragmentMineBinding> {
    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }
}
