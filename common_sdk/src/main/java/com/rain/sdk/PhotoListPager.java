package com.rain.sdk;

import androidx.annotation.IntRange;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: PhotoListPager
 * @CreateDate: 2020/9/20 17:36
 * @Describe:
 */
public class PhotoListPager {
    public static final int DEFAULT_PER_PAGE = 10;

    @IntRange(from = 0, to = Integer.MAX_VALUE)
    public @interface PerPageRule {
    }

    @IntRange(from = 1)
    public @interface PageRule {
    }
}
