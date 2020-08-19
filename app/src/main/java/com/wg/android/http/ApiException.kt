package com.wg.android.http

class ApiException(var code: Int, override var message: String) : RuntimeException()