package com.rain.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.os.Build;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/**
 * @Author : Rain
 * @CreateDate : 2020/9/10 18:32
 * @Version : 1.0
 * @Descroption : 动画工具类
 */
public class AnimUtils {


    public static class ObservableColorMatrix extends ColorMatrix {
        private float saturation = 1f;

        public ObservableColorMatrix() {
            super();
        }

        private float getSaturation() {
            return saturation;
        }

        //设置颜色矩阵的饱和度，0是灰色的，1是原图
        @Override
        public void setSaturation(float saturation) {
            this.saturation = saturation;
            super.setSaturation(saturation);
        }

        public static final Property<ObservableColorMatrix, Float> SATURATION
                = new FloatProperty<ObservableColorMatrix>("saturation") {

            @Override
            public void setValue(ObservableColorMatrix cm, float value) {
                cm.setSaturation(value);
            }

            @Override
            public Float get(ObservableColorMatrix cm) {
                return cm.getSaturation();
            }
        };
    }


    static abstract class FloatProperty<T> extends Property<T, Float> {
        FloatProperty(String name) {
            super(Float.class, name);
        }

        /**
         * A type-specific override of the {@link #set(Object, Float)} that is faster when dealing
         * with fields of type <code>float</code>.
         */
        public abstract void setValue(T object, float value);

        @Override
        final public void set(T object, Float value) {
            setValue(object, value);
        }
    }

    private static Interpolator fastOutSlowIn;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Interpolator getFastOutSlowInInterpolator(Context context) {
        if (fastOutSlowIn == null) {
            fastOutSlowIn = AnimationUtils.loadInterpolator(context, android.R.interpolator.fast_out_slow_in);
        }
        return fastOutSlowIn;
    }

}
