package com.wg.android.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProxyCodeBean(
    val createTime: Long,
    val deleted: Int,
    val id: Int,
    val proxyCode: String,
    val showType: Int,
    val status: Int,
    val updateTime: Long,
    val userId: Int
) : Parcelable