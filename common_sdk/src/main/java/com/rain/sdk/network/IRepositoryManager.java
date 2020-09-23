package com.rain.sdk.network;

import androidx.annotation.NonNull;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: IRepositoryManager
 * @CreateDate: 2020/7/4 14:40
 * @Describe:
 */
public interface IRepositoryManager {

    @NonNull
    <T> T obtainRetrofitService(@NonNull Class<T> service);
}
