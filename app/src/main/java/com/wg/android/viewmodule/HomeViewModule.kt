package com.wg.android.viewmodule

import androidx.lifecycle.MutableLiveData
import com.wg.android.R
import com.wg.android.base.BaseViewModule
import com.wg.android.module.HomeData
import com.wg.android.repository.HomeRepository
import com.wg.android.ui.MainActivity
import com.wg.android.ui.ProgressDialogFragment

class HomeViewModule : BaseViewModule() {
    private val homeRepository by lazy { HomeRepository() }

    val data: MutableLiveData<MutableList<HomeData>> = MutableLiveData()

    fun getData(
        map: MutableMap<String, Any>,
        mainActivity: MainActivity
    ) {
        launch(
            block = {
                val dailog = ProgressDialogFragment.newInstance()
                dailog.show(mainActivity.supportFragmentManager, R.string.loading, false)
                val bean = async{homeRepository.getHomeBanner(map)}
                val da = async { homeRepository.getCode() }
                dailog.dismiss()
                data.value = bean.await()
            },
            error = {

            }
        )
    }
}