package com.wg.android.http

import com.wg.android.module.HomeData
import com.wg.android.module.InvitedUrlBean
import com.wg.android.module.ProxyCodeBean
import kotlinx.coroutines.Deferred
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("banner/list")
    suspend fun getBannerAsync(@FieldMap map : MutableMap<String,Any>) : ApiResult<MutableList<HomeData>>

    //代理码
    @POST("proxyCode/getOne")
    suspend fun getCode() : ApiResult<ProxyCodeBean>

    //推广链接
    @FormUrlEncoded
    @POST("configInfo/detail")
    suspend fun getInvUrl(@FieldMap map : MutableMap<String,Any>) : ApiResult<InvitedUrlBean>

}