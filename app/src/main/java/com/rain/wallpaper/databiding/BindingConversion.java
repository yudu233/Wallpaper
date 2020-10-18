package com.rain.wallpaper.databiding;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: BindingConversion
 * @CreateDate: 2020/10/18 22:58
 * @Describe:
 */

public class BindingConversion {
//    @androidx.databinding.BindingConversion
//    public static Drawable covertStringToDrawable(String str){
//        if (str.equals("open")){
//            return ResourceUtils.getDrawable(R.drawable.shape_classify_status_open);
//        }else {
//            return   ResourceUtils.getDrawable(R.drawable.shape_classify_status_close);
//        }
//    }

    @androidx.databinding.BindingConversion
    public static boolean covertStringToBoolean(String str){
        return str.equals("open");
    }
}
