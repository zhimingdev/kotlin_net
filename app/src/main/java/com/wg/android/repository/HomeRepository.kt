package com.wg.android.repository

import com.wg.android.http.RetrofitHelper

class HomeRepository {
    suspend fun getHomeBanner(map: MutableMap<String,Any>) = RetrofitHelper.api.getBannerAsync(map).apiData()

    suspend fun getCode() = RetrofitHelper.api.getCode().apiData()

    suspend fun geturl(map: MutableMap<String,Any>) = RetrofitHelper.api.getInvUrl(map).apiData()
}