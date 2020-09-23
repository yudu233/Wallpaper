package com.rain.sdk.network.rxWeaver

import io.reactivex.Single

/**
 * @author:duyu
 * @org :   www.yudu233.com
 * @email : yudu233@gmail.com
 * @date :  2019/4/1 18:15
 * @filename : RetryConfig
 * @describe : 重连配置
 * maxRetries:可重连次数；delay:重试等待时间；condition:开关
 */

private const val DEFAULT_RETRY_TIMES = 1
private const val DEFAULT_DELAY_DURATION = 1000

@Suppress("DataClassPrivateConstructor")
data class RetryConfig private constructor(
        val maxRetries: Int,
        val delay: Int,
        val condition: () -> Single<Boolean>
) {
    companion object Extension {

        fun none(): RetryConfig = simpleInstance { Single.just(false) }


        private fun simpleInstance(maxRetries: Int = DEFAULT_RETRY_TIMES,
                                   delay: Int = DEFAULT_DELAY_DURATION,
                                   condition: () -> Single<Boolean>): RetryConfig =
                RetryConfig(
                        maxRetries = maxRetries,
                        delay = delay,
                        condition = condition
                )
    }
}