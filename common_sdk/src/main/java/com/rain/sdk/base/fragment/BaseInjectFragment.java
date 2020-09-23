package com.rain.sdk.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.LogUtils;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: BaseInjectFragment
 * @CreateDate: 2020/8/13 23:00
 * @Describe:
 */
public abstract class BaseInjectFragment<B extends ViewDataBinding> extends Fragment {

    protected B binding;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBinding(view);
        initView();
    }

    protected void initBinding(View view) {
        binding = DataBindingUtil.bind(view);
        binding.setLifecycleOwner(this);
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

}
