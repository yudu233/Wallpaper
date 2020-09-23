package com.rain.sdk.network.rxWeaver

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author:duyu
 * @org :   www.yudu233.com
 * @email : yudu233@gmail.com
 * @date :  2019/4/1 18:14
 * @filename : GlobalErrorTransformer
 * @describe : 全局Error处理
 */

typealias OnNextInterceptor<T> = (T) -> Observable<T>

typealias OnErrorResumeNext<T> = (Throwable) -> Observable<T>
typealias OnErrorRetrySupplier = (Throwable) -> RetryConfig
typealias OnErrorConsumer = (Throwable) -> Unit

class GlobalErrorTransformer<T>(
        private val onNextInterceptor: OnNextInterceptor<T> = { Observable.just(it) },
        private val onErrorResumeNext: OnErrorResumeNext<T> = { Observable.error(it) },
        private val onErrorRetrySupplier: OnErrorRetrySupplier = { RetryConfig.none() },
        private val onErrorConsumer: OnErrorConsumer = { }
) : ObservableTransformer<T, T>,
        FlowableTransformer<T, T>,
        SingleTransformer<T, T>,
        MaybeTransformer<T, T>,
        CompletableTransformer {

    override fun apply(upstream: Observable<T>): Observable<T> =
            upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap {
                        onNextInterceptor(it)
                    }
                    .onErrorResumeNext { throwable: Throwable ->
                        onErrorResumeNext(throwable)
                    }
                    .retryWhen(ObservableRetryDelay(onErrorRetrySupplier))
                    .doOnError(onErrorConsumer)

    override fun apply(upstream: Completable): Completable =
            upstream
                    .onErrorResumeNext {
                        onErrorResumeNext(it).ignoreElements()
                    }
                    .retryWhen(FlowableRetryDelay(onErrorRetrySupplier))
                    .doOnError(onErrorConsumer)

    override fun apply(upstream: Flowable<T>): Flowable<T> =
            upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap {
                        onNextInterceptor(it)
                                .toFlowable(BackpressureStrategy.BUFFER)
                    }
                    .onErrorResumeNext { throwable: Throwable ->
                        onErrorResumeNext(throwable)
                                .toFlowable(BackpressureStrategy.BUFFER)
                    }
                    .retryWhen(FlowableRetryDelay(onErrorRetrySupplier))
                    .doOnError(onErrorConsumer)

    override fun apply(upstream: Maybe<T>): Maybe<T> =
            upstream
                    .flatMap {
                        onNextInterceptor(it)
                                .firstElement()
                    }
                    .onErrorResumeNext { throwable: Throwable ->
                        onErrorResumeNext(throwable)
                                .firstElement()
                    }
                    .retryWhen(FlowableRetryDelay(onErrorRetrySupplier))
                    .doOnError(onErrorConsumer)

    override fun apply(upstream: Single<T>): Single<T> =
            upstream
                    .flatMap {
                        onNextInterceptor(it)
                                .firstOrError()
                    }
                    .onErrorResumeNext { throwable ->
                        onErrorResumeNext(throwable)
                                .firstOrError()
                    }
                    .retryWhen(FlowableRetryDelay(onErrorRetrySupplier))
                    .doOnError(onErrorConsumer)
}