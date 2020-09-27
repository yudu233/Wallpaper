package com.rain.wallpaper.ui;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rain.wallpaper.R;
import com.rain.wallpaper.ui.classify.ClassifyFragment;
import com.rain.wallpaper.ui.fragment.MineFragment;
import com.rain.wallpaper.ui.recommend.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments;
    private Fragment mCurrentFragment = null;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initFragment();
        navigationView = findViewById(R.id.navigation_view);
//        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
//        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.recommendFragment:
                    switchFragment(0);
                    return true;
                case R.id.classifyFragment:
                    switchFragment(1);
                    return true;
                case R.id.mineFragment:
                    switchFragment(2);
                    return true;
            }
            return false;
        });
        //默认选中第一个
        navigationView.setSelectedItemId(navigationView.getMenu().getItem(0).getItemId());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            // 循环remove掉所有的fragment
            transaction.remove(fragments.get(i));
        }
        transaction.commitAllowingStateLoss();
        super.onSaveInstanceState(outState);
        // 重新设置BottomNavigationView的默认选中项
        navigationView.setSelectedItemId(navigationView.getMenu().getItem(0).getItemId());
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (fragments != null) {
            fragments.clear();
        } else {
            fragments = new ArrayList<>();
        }
        RecommendFragment recommendFragment = RecommendFragment.newInstance();
        ClassifyFragment classifyFragment = ClassifyFragment.newInstance();
        MineFragment mineFragment = MineFragment.newInstance();
        fragments.add(recommendFragment);
        fragments.add(classifyFragment);
        fragments.add(mineFragment);

        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            transaction.add(R.id.frameLayout, fragment);
            if (mCurrentFragment == fragment) {
                transaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                transaction.hide(fragment);
                transaction.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
            }
        }
        transaction.commit();
    }

    private void switchFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (fragments != null && fragments.size() > 0) {
            Fragment fragment = fragments.get(position);
            if (null != fragment && mCurrentFragment != fragment) {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment);
                    transaction.setMaxLifecycle(mCurrentFragment, Lifecycle.State.STARTED);
                }
                mCurrentFragment = fragment;
                transaction.show(fragment);
                transaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
                transaction.commit();
            }
        }
    }
}