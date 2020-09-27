package com.rain.api.data;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ClassifyEntity
 * @CreateDate: 2020/9/27 23:19
 * @Describe:
 */
public class ClassifyEntity {
    public String classifyTitle;
    public int classifyResId;

    public ClassifyEntity(String classifyTitle, int classifyResId) {
        this.classifyTitle = classifyTitle;
        this.classifyResId = classifyResId;
    }
}
