package com.wg.android.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wg.android.http.ApiException
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.SocketTimeoutException

typealias Block<T> = suspend () -> T
typealias Error = suspend (e: Exception) -> Unit

open class BaseViewModule : ViewModel() {

    protected fun launch(block: Block<Unit>,error : Error? = null){
        viewModelScope.launch {
            try {
                block.invoke()
            }catch (e : Exception) {
                onError(e)
                error?.invoke(e)
            }
        }
    }

    private fun onError(e :Exception) {
        when (e) {
            is ApiException -> {
                when(e.code) {
                   else -> println(e.message)
                }
            }
            is ConnectException -> {
                println("网络链接异常")
            }
            is SocketTimeoutException -> {
                println("网络链接超时")
            }
            else -> {
                println("未知异常")
            }
        }
    }

    /**
     * 创建并执行协程
     * @param block 协程中执行
     * @return Deferred<T>
     */
    protected fun <T> async(block: Block<T>): Deferred<T> {
        return viewModelScope.async { block.invoke()}
    }

}