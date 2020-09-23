package com.rain.sdk.network.rxWeaver

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

/**
 * @author:duyu
 * @org :   www.yudu233.com
 * @email : yudu233@gmail.com
 * @date :  2019/4/1 18:14
 * @filename : ObservableRetryDelay
 * @describe : 重连验证计时
 * [flatMap] : 把一个[Observable] 通过某种方法转换为多个 [Observable]，然后再把这些分散的 [Observable]装进一个单一的发射器 [Observable]
 * [flatMapObservable操作符]在Single中flatMap只能返回Single,flatMapObservable就不同了，它支持将Single转化为Observable对象，可以返回多个值
 */
class ObservableRetryDelay(
        val retryConfigProvider: (Throwable) -> RetryConfig
) : Function<Observable<Throwable>, ObservableSource<*>> {

    private var retryCount: Int = 0

    override fun apply(throwableObs: Observable<Throwable>): ObservableSource<*> {
        return throwableObs
                .flatMap { error ->
                    val (maxRetries, delay, retryCondition) = retryConfigProvider(error)

                    if (++retryCount <= maxRetries) {
                        retryCondition()
                                .flatMapObservable { retry ->
                                    if (retry)
                                        Observable.timer(delay.toLong(), TimeUnit.MILLISECONDS)
                                    else
                                        Observable.error<Any>(error)
                                }
                    } else Observable.error<Any>(error)
                }
    }
}