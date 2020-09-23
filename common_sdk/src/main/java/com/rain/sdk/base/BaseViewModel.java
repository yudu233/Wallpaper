package com.rain.sdk.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.rain.sdk.ListResource;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: BaseViewModel
 * @CreateDate: 2020/8/19 22:16
 * @Describe:
 */
public abstract class BaseViewModel<T> extends ViewModel {

    private MutableLiveData<ListResource<T>> listResource;
    private ReadWriteLock lock;

    public BaseViewModel() {
        this.listResource = null;
        this.lock = new ReentrantReadWriteLock();
    }

    protected boolean init(@NonNull ListResource<T> resource) {
        if (listResource == null) {
            listResource = new MutableLiveData<>();
            listResource.setValue(resource);
            return true;
        }
        return false;
    }

    public abstract void refresh();

    public abstract void load();

    public void observeListResource(@NonNull LifecycleOwner owner,
                                    @NonNull ListResourceObserver<T> observer) {
        listResource.observe(owner, new Observer<ListResource<T>>() {
            @Override
            public void onChanged(ListResource<T> resource) {
                observer.observe(BaseViewModel.this);
            }
        });

    }

    public void writeDataSource(DataListWriter<T> writer) {
        lock.writeLock().lock();
        listResource.setValue(writer.execute(listResource.getValue()));
        lock.writeLock().unlock();
    }


    public void readDataList(DataListReader<T> reader) {
        assert listResource.getValue() != null;

        lock.readLock().lock();
        reader.execute(listResource.getValue().dataList);
        lock.readLock().unlock();
    }

    public int getListRequestPage() {
        assert listResource.getValue() != null;

        lock.readLock().lock();
        int page = listResource.getValue().getRequestPage();
        lock.readLock().unlock();

        return page;
    }

    public int getListPerPage() {
        assert listResource.getValue() != null;

        lock.readLock().lock();
        int perPage = listResource.getValue().perPage;
        lock.readLock().unlock();

        return perPage;
    }

    public ListResource.State getListState() {
        assert listResource.getValue() != null;

        lock.readLock().lock();
        ListResource.State state = listResource.getValue().state;
        lock.readLock().unlock();

        return state;
    }

    public int getListSize() {
        assert listResource.getValue() != null;

        lock.readLock().lock();
        int size = listResource.getValue().dataList.size();
        lock.readLock().unlock();

        return size;
    }


    public interface DataListReader<T> {
        void execute(List<T> list);
    }

    public interface DataListWriter<T> {
        ListResource<T> execute(ListResource<T> resource);
    }

    public interface ListResourceObserver<T> {
        void observe(BaseViewModel<T> viewModel);
    }

}
