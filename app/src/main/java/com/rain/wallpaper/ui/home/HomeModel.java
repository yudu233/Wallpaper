package com.rain.wallpaper.ui.home;

import com.rain.wallpaper.http.IRepositoryManager;
import com.rain.wallpaper.mvp.BaseModel;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: HomeModel
 * @CreateDate: 2020/7/4 14:43
 * @Describe:
 */
public class HomeModel extends BaseModel {
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
