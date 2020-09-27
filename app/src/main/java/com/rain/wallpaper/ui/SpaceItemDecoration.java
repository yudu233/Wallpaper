package com.rain.wallpaper.ui;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: SpaceItemDecoration
 * @CreateDate: 2020/9/27 20:58
 * @Describe:
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int count;

    public SpaceItemDecoration(int space,int count) {
        this.space = space;
        this.count = count;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = space;
        outRect.left = space;
        if (parent.getChildAdapterPosition(view) % 2 !=0){
            outRect.right = space;
        }
        if (parent.getChildAdapterPosition(view) > parent.getChildCount()-2){
            outRect.bottom = space;
        }

    }
}
