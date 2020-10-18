package com.rain.wallpaper.ui;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import com.rain.sdk.base.activity.BaseInjectActivity;
import com.rain.wallpaper.R;
import com.rain.wallpaper.databinding.ActivityPhotoListBinding;
import com.rain.wallpaper.ui.recommend.RecommendFragment;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: PhotoListActivity
 * @CreateDate: 2020/10/9 21:28
 * @Describe:
 */
@AndroidEntryPoint
public class PhotoListActivity extends BaseInjectActivity<ActivityPhotoListBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_list;
    }

    @Override
    protected void initView() {
        String classify = getIntent().getStringExtra("classify");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        RecommendFragment recommendFragment = RecommendFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString("classify", classify);
        recommendFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayout, recommendFragment).commit();

    }
}
