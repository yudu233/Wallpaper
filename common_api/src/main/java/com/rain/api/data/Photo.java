package com.rain.api.data;

import android.content.Context;

import androidx.annotation.Size;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: Photo
 * @CreateDate: 2020/9/9 22:19
 * @Describe: 转换后的图片信息
 */
public class Photo {

    public static final float MAX_SCALE = 2.5f;

    private ImageInfo imageInfo;

    public String photoUrl;
    public String thumbUrl;
    public @Size
    int[] photoSize;

    public Photo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
        this.photoUrl = imageInfo.getUrls().getRegular()
                .replace("https://images.unsplash.com/", "http://unsplash.nesnode.com/");
        this.thumbUrl = imageInfo.getUrls().getThumb()
                .replace("https://images.unsplash.com/", "http://unsplash.nesnode.com/");
        this.photoSize = new int[]{
                ScreenUtils.getScreenWidth(), (int) ((float) ScreenUtils.getScreenWidth() / imageInfo.getWidth() * imageInfo.getHeight())
        };
    }

    /**
     * 以jpg格式返回宽度为1080像素的照片 宽-高
     *
     * @return
     */
    @Size(2)
    public int[] getRegularSize() {
        return new int[]{
                1080, (int) (1080f) / imageInfo.getWidth() * imageInfo.getHeight()
        };
    }

    /**
     * 以最大尺寸的jpg格式返回照片。为了提高性能，我们不建议您使用此功能，因为这些照片会为您的用户缓慢加载
     *
     * @param context
     * @return
     */
    @Size(2)
    public int[] getFullSize(Context context) {
        return getCropScaleSize(context, MAX_SCALE);
    }


    /**
     * 获取裁剪缩放后的图片宽高
     *
     * @param context
     * @param scale
     * @return
     */
    @Size(2)
    private int[] getCropScaleSize(Context context, float scale) {
        float screenRatio = 1.f
                * context.getResources().getDisplayMetrics().widthPixels
                / context.getResources().getDisplayMetrics().heightPixels;
        float imageRatio = 1.f * imageInfo.getWidth() / imageInfo.getHeight();

        if (imageRatio >= screenRatio) {
            int maxScaleHeight = (int) (context.getResources().getDisplayMetrics().heightPixels * scale);
            if (imageInfo.getHeight() <= maxScaleHeight) {
                return new int[]{imageInfo.getWidth(), imageInfo.getHeight()};
            } else {
                return new int[]{
                        (int) (1.f * maxScaleHeight * imageInfo.getWidth() / imageInfo.getHeight()),
                        maxScaleHeight
                };
            }
        } else {
            int maxScaleWidth = (int) (context.getResources().getDisplayMetrics().widthPixels * scale);
            if (imageInfo.getWidth() <= maxScaleWidth) {
                return new int[]{imageInfo.getWidth(), imageInfo.getHeight()};
            } else {
                return new int[]{
                        maxScaleWidth,
                        (int) (1.f * maxScaleWidth * imageInfo.getHeight() / imageInfo.getWidth())
                };
            }
        }
    }

    /**
     * 根据基本图片网址拼接图像参数构造自己的图像URL
     *
     * @param size
     * @return
     */
    public String getUrl(@Size(2) int[] size) {
        return imageInfo.getUrls().getRaw()
                + "?q=75&fm=jpg"
                + "&w=" + size[0]
                + "&h=" + size[1]
                + "&fit=crop";
    }

//    public boolean isComplete() {
//        return imageInfo.getE != null;
//    }
}
