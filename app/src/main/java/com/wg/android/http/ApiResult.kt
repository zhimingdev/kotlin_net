package com.wg.android.http

data class ApiResult<T>(private val code : Int ,private val message: String ,private var body: T) {
    fun apiData() : T{
        if (code == 200){
            return body
        }else{
            throw ApiException(code, message)
        }
    }
}