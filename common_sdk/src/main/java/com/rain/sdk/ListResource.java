package com.rain.sdk;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: ListResource
 * @CreateDate: 2020/9/20 17:53
 * @Describe:
 */
public class ListResource<T> {
    public final List<T> dataList;
    public final State state;
    private final int dataPage;
    public final int perPage;

    public enum State {
        SUCCESS, ALL_LOADED, ERROR, REFRESHING, LOADING
    }

    public ListResource(List<T> dataList, State state, int dataPage, int perPage) {
        this.dataList = dataList;
        this.state = state;
        this.dataPage = dataPage;
        this.perPage = perPage;
    }

    public int getRequestPage() {
        switch (state) {
            case REFRESHING:
                return 1;

            case LOADING:
                return dataPage + 1;

            default:
                return dataPage;
        }
    }


    public static <T> ListResource<T> loading(@NonNull ListResource<T> current) {
        return new ListResource<>(
                current.dataList,
                State.LOADING,
                current.dataPage,
                current.perPage
        );
    }

    public static <T> ListResource<T> error(int page, int perPage) {
        return new ListResource<>(
                new ArrayList<>(),
                State.ERROR,
                page,
                perPage);
    }

    public static <T> ListResource<T> error(@NonNull ListResource<T> current) {
        return new ListResource<>(
                current.dataList,
                State.ERROR,
                current.dataPage,
                current.perPage
        );
    }

    public static <T> ListResource<T> refreshing(@PhotoListPager.PerPageRule int page,
                                                 @PhotoListPager.PerPageRule int perPage) {
        return new ListResource<>(
                new ArrayList<>(),
                State.REFRESHING,
                page,
                perPage
        );
    }

    public static <T> ListResource<T> refreshing(@NonNull ListResource<T> current) {
        return new ListResource<>(
                current.dataList,
                State.REFRESHING,
                current.dataPage,
                current.perPage
        );
    }

    public static <T> ListResource<T> refreshSuccess(@NonNull ListResource<T> oldList, @NonNull List<T> newList) {
        List<T> list = oldList.dataList;
        list.addAll(newList);

        return new ListResource<>(
                list,
                State.SUCCESS,
                1,
                oldList.perPage
        );
    }

    public static <T> ListResource<T> loadSuccess(@NonNull ListResource<T> oldList, @NonNull List<T> newList) {
        List<T> list = oldList.dataList;
        list.addAll(newList);

        return new ListResource<>(
                list,
                State.SUCCESS,
                oldList.dataPage + 1,
                oldList.perPage
        );
    }

}
