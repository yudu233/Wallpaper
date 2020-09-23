package com.rain.sdk.network

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.rain.sdk.R
import com.rain.sdk.network.rxWeaver.GlobalErrorTransformer
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import javax.net.ssl.SSLHandshakeException


/**
 * @author:duyu
 * @org :   www.yudu233.com
 * @email : yudu233@gmail.com
 * @date :  2019/4/1 17:52
 * @filename : Error
 * @describe : 全局错误处理
 */
fun <T> globalHandleError(): GlobalErrorTransformer<T> = GlobalErrorTransformer(

        onErrorConsumer = { error ->
            LogUtils.e(error.toString())

            when (error) {
                is HttpException -> {
                    val errorData = Gson().fromJson<ErrorResponse>(error.response()?.errorBody()?.charStream()?.readText().toString(), ErrorResponse::class.java)
                    LogUtils.e(errorData.toString())
                    when (error.code()) {

                    }
                }

                is ConnectException -> {
                    ToastUtils.showShort(R.string.error_connected)
                }
                is JsonParseException, is JSONException -> {
                    ToastUtils.showShort(R.string.error_parse_exception)
                }

                is SSLHandshakeException -> {
                    ToastUtils.showShort(R.string.error_ssl_exception)
                }

                else -> {
                    ToastUtils.showShort(R.string.error_response_throwable)
                }

            }
        }
)
