package com.rain.sdk.network

/**
 * Author: Rain
 * Org: www.yudu233.com
 * Email: yudu233@gmail.com
 * Date: 2019/8/12 22:24
 * Describe:
 */

data class ErrorResponse(
        val code: Int,
        val message: String,
        val msg: String


) {
    override fun toString(): String {
        return "ErrorResponse(code=$code, message='$message', msg='$msg')"
    }
}