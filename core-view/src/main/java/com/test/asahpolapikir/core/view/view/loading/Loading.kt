package com.myultimate.core.view.view.loading

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentManager
import com.test.asahpolapikir.core.view.Constants

/**
 * Created by Hans on 19/10/22.
 */

@SuppressLint("StaticFieldLeak")
private var loadingFragment: LoadingFragment? = null

fun FragmentManager.showProgressDialog(
    loadingFrag: LoadingFragment?,
    timeoutDuration: Long? = null
) {

    //loadingFragment = loadingFrag ?: LoadingFragment()
    if (loadingFragment == null) {
        loadingFragment = loadingFrag ?: LoadingFragment()
        timeoutDuration?.let { loadingFragment?.setTimeoutDuration(it) }

        try {
            loadingFragment?.show(this, Constants.LOADING_FRAGMENT)

            loadingFragment?.setOnTimeoutListener(object : LoadingListener {
                override fun onTimeout() {
                    cancelProgressDialog()
                }
            })
        } catch (e: Exception) {
            loadingFragment = null
        }
    } else {
        loadingFragment?.cancelTimeoutTimer()
        timeoutDuration?.let { loadingFragment?.setTimeoutDuration(it) }
        loadingFragment?.createTimeoutTimer()
    }
}

fun FragmentManager.cancelProgressDialog() {
    try {
        if (loadingFragment != null) {
            loadingFragment?.dismissAllowingStateLoss()
            loadingFragment = null
        }
    } catch (e: Exception) {

    }
}