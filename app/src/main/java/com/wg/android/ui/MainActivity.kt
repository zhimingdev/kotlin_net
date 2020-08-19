package com.wg.android.ui

import android.os.Environment
import androidx.lifecycle.Observer
import com.wg.android.R
import com.wg.android.base.BaseActivity
import com.wg.android.viewmodule.HomeViewModule
import kotlinx.android.synthetic.main.activity_main.*
import permissions.dispatcher.RuntimePermissions


@RuntimePermissions
class MainActivity : BaseActivity<HomeViewModule>(){

    override fun getLayoutId(): Int  = R.layout.activity_main

    override fun initData() {
        println("手机内部存储;  "+Environment.getExternalStorageDirectory().toString())
        val map = mutableMapOf<String,Any>()
        map["type"] = 2
        mViewModel.getData(map,this)
        mViewModel.run {
            data.observe(this@MainActivity, Observer {
                tv_main.text = it.size.toString()
            })
        }
    }

    override fun initLisenter() {
        tv_main.setOnClickListener {
        }
    }

    override fun viewModelClass() = HomeViewModule::class.java

}