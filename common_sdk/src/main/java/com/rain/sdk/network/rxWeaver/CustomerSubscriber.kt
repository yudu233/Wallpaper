package com.rain.sdk.network.rxWeaver

import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.ToastUtils
import com.rain.sdk.R
import com.rain.sdk.base.BaseViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * @author:duyu
 * @org :   www.yudu233.com
 * @email : yudu233@gmail.com
 * @date :  2019/8/12 15:49
 * @filename : CustomerSubscriber
 * @describe :
 */
abstract class CustomerSubscriber<T>(private val showLoading: Boolean) : Observer<T> {

    override fun onSubscribe(d: Disposable) {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShort(R.string.error_network)
            d.dispose()
            return
        }
        if (showLoading) {
            //showLoadingDialog()
        }
    }

    override fun onComplete() {
        if (showLoading) {
            //dismissDialog()
        }
    }

    override fun onError(e: Throwable) {
        if (showLoading) {
            //dismissDialog()
        }
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    protected abstract fun onSuccess(response: T)


}