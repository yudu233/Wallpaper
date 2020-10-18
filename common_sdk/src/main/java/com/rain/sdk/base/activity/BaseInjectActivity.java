package com.rain.sdk.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: BaseActivity
 * @CreateDate: 2020/9/12 13:09
 * @Describe:
 */
public abstract class BaseInjectActivity<B extends ViewDataBinding> extends AppCompatActivity {
    protected B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        initView();
    }

    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        binding.setLifecycleOwner(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
