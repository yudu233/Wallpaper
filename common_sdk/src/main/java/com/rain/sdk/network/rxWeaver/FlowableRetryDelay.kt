package com.rain.sdk.network.rxWeaver

import io.reactivex.Flowable
import io.reactivex.functions.Function
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit

/**
 * @author:duyu
 * @org :   www.yudu233.com
 * @email : yudu233@gmail.com
 * @date :  2019/4/1 18:14
 * @filename : FlowableRetryDelay
 * @describe : 背压支持
 */
class FlowableRetryDelay(
        val retryConfigProvider: (Throwable) -> RetryConfig
) : Function<Flowable<Throwable>, Publisher<*>> {

    private var retryCount: Int = 0

    override fun apply(throwableFlowable: Flowable<Throwable>): Publisher<*> {
        return throwableFlowable
                .flatMap { error ->
                    val (maxRetries, delay, retryTransform) = retryConfigProvider(error)

                    if (++retryCount <= maxRetries) {
                        retryTransform()
                                .flatMapPublisher { retry ->
                                    if (retry)
                                        Flowable.timer(delay.toLong(), TimeUnit.MILLISECONDS)
                                    else
                                        Flowable.error<Any>(error)
                                }
                    } else Flowable.error<Any>(error)
                }
    }
}