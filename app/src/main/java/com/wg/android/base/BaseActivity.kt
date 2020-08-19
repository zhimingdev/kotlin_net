package com.wg.android.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initViewModel()
        initData()
        initLisenter()
    }

    //布局
    open fun getLayoutId(): Int = 0

    //初始化
    abstract fun initData()

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(viewModelClass())
    }

    //获取当前module
    protected abstract fun viewModelClass(): Class<VM>

    //监听事件
    abstract fun initLisenter()

    //跳转
    fun startFromActivity(jclazz: Class<Any>, bundle: Bundle?, key: String) {
        val intent = Intent(this, jclazz)
        bundle?.let {
            intent.putExtra(key, bundle)
        }
        startActivity(intent)
    }

}