package com.wg.android.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InvitedUrlBean(
    val key: String,
    val name: String,
    val value: String
) : Parcelable