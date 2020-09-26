package com.rain.sdk.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

import androidx.annotation.IntRange;
import androidx.annotation.Size;
import androidx.appcompat.widget.AppCompatImageView;

import com.blankj.utilcode.util.ConvertUtils;
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

    private Paint topPaint;
    private Paint bottomPaint;

    // measure size according the width and height. (proportion)
    private float width = 1;
    private float height = 0.6f;

    private boolean dynamicSize = true;
    private boolean showShadow = false;

    private int textPosition;
    private static final int POSITION_NONE = 0;
    private static final int POSITION_TOP = 1;
    private static final int POSITION_BOTTOM = -1;
    private static final int POSITION_BOTH = 2;

    @IntRange(from = 0)
    private @interface SizeRule {}

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
        this.textPosition = a.getInt(R.styleable.CoverImageView_civ_shadow_position, POSITION_NONE);
        a.recycle();

        this.topPaint = new Paint();
        this.bottomPaint = new Paint();
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
        setPaintStyle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showShadow) {
            switch (textPosition) {
                case POSITION_TOP: {
                    canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), topPaint);
                    break;
                }
                case POSITION_BOTTOM: {
                    canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), bottomPaint);
                    break;
                }
                case POSITION_BOTH: {
                    canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), topPaint);
                    canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), bottomPaint);
                    break;
                }
            }
        }
    }

    @Size(2)
    public float[] getSize() {
        return new float[] {width, height};
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
        return new int[] {
                measureWidth,
                (int) (measureWidth * h / w)
        };
    }

    public void setShowShadow(boolean show) {
        this.showShadow = show;
        invalidate();
    }

    private void setPaintStyle() {
        topPaint.setShader(
                new LinearGradient(
                        0, 0,
                        0, (int) ConvertUtils.dp2px(128),
                        new int[]{
                                Color.argb((int) (255 ), 0, 0, 0),
                                Color.argb((int) (255 ), 0, 0, 0),
                                Color.argb((int) (255 ), 0, 0, 0),
                                Color.argb(0, 0, 0, 0)
                        },
                        null,
                        Shader.TileMode.CLAMP
                )
        );

        bottomPaint.setShader(
                new LinearGradient(
                        0, getMeasuredHeight(),
                        0, getMeasuredHeight() - (int) ConvertUtils.dp2px(72),
                        new int[]{
                                Color.argb((int) (255 ), 0, 0, 0),
                                Color.argb((int) (255 ), 0, 0, 0),
                                Color.argb((int) (255 ), 0, 0, 0),
                                Color.argb(0, 0, 0, 0)
                        },
                        null,
                        Shader.TileMode.CLAMP
                )
        );
    }
}

