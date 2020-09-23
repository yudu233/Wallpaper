package com.rain.sdk.image;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorMatrixColorFilter;

import androidx.annotation.FloatRange;
import androidx.appcompat.widget.AppCompatImageView;

import com.rain.sdk.utils.AnimUtils;

/**
 * @Author : Rain
 * @CreateDate : 2020/9/10 18:38
 * @Version : 1.0
 * @Descroption : 图片相关工具栏
 */
public class ImageUtils {


    public static final long duration = 3000L;


    public static void setImageViewSaturation(AppCompatImageView imageView,
                                              @FloatRange(from = 0, to = 1) float saturation) {
        AnimUtils.ObservableColorMatrix matrix = new AnimUtils.ObservableColorMatrix();
        matrix.setSaturation(saturation);
        imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
    }

    public static void startSaturationAnimation(Context context, final AppCompatImageView imageView) {
        startSaturationAnimation(context, imageView, duration);
    }

    public static void startSaturationAnimation(Context context, final AppCompatImageView imageView, long duration) {
        imageView.setHasTransientState(true);
        final AnimUtils.ObservableColorMatrix matrix = new AnimUtils.ObservableColorMatrix();
        final ObjectAnimator saturation = ObjectAnimator.ofFloat(
                matrix, AnimUtils.ObservableColorMatrix.SATURATION, 0f, 1f);
        saturation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
            }
        });
        saturation.setDuration(duration);
        saturation.setInterpolator(AnimUtils.getFastOutSlowInInterpolator(context));
        saturation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.clearColorFilter();
                imageView.setHasTransientState(false);
            }
        });
        saturation.start();
    }
}
