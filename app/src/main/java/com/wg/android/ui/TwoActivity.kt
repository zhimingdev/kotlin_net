package com.wg.android.ui

import com.wg.android.R
import com.wg.android.base.BaseActivity
import com.wg.android.viewmodule.HomeViewModule

class TwoActivity : BaseActivity<HomeViewModule>() {

    override fun getLayoutId(): Int = R.layout.activity_two

    override fun initData() {
    }

    override fun viewModelClass() = HomeViewModule::class.java

    override fun initLisenter() {
    }
}