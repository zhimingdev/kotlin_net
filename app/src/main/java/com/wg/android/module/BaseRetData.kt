package com.wg.android.module

data class BaseRetData<T> (
    //信息
    val message: String,
    //返回请求码
    val code: Int,
    //返回数据
    val body: T
)