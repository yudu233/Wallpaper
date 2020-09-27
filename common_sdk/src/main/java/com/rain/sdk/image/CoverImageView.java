package com.rain.sdk.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.IntRange;
import androidx.annotation.Size;
import androidx.appcompat.widget.AppCompatImageView;

import com.rain.sdk.R;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: CoverImageView
 * @CreateDate: 2020/9/26 13:25
 * @Describe:
 */
public class CoverImageView extends AppCompatImageView {

    private float width = 1;
    private float height = 0.6f;

    private boolean dynamicSize = true;

    @IntRange(from = 0)
    private @interface SizeRule {
    }

    public CoverImageView(Context context) {
        super(context);
    }

    public CoverImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initialize(context, attrs, 0);
    }

    public CoverImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initialize(context, attrs, defStyleAttr);
    }

    private void initialize(Context c, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.CoverImageView, defStyleAttr, 0);
        this.dynamicSize = a.getBoolean(R.styleable.CoverImageView_civ_dynamic_size, true);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (width >= 0 && height >= 0) {
            if (!dynamicSize) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else {
                int[] size = getMeasureSize(MeasureSpec.getSize(widthMeasureSpec), width, height);
                setMeasuredDimension(size[0], size[1]);
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }


    @Size(2)
    public float[] getSize() {
        return new float[]{width, height};
    }

    public void setSize(@SizeRule int w, @SizeRule int h) {
        if (dynamicSize) {
            width = w;
            height = h;
            requestLayout();
        }
    }

    @Size(2)
    public static int[] getMeasureSize(int measureWidth, float w, float h) {
        return new int[]{
                measureWidth,
                (int) (measureWidth * h / w)
        };
    }
}

