package com.test.asahpolapikir.core.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.myultimate.core.view.view.loading.LoadingFragment
import com.myultimate.core.view.view.loading.cancelProgressDialog
import com.myultimate.core.view.view.loading.showProgressDialog

/**
 * Created by Hans on 19/10/22.
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    open lateinit var binding: VB

    private var loadingFragment: LoadingFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayout(layoutInflater))
    }

    private fun getInflatedLayout(inflater: LayoutInflater): View {
        binding = setBinding(inflater)
        return binding.root
    }

    abstract fun setBinding(layoutInflater: LayoutInflater): VB

    fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, duration).show()
    }

    fun showProgressDialog() {
        supportFragmentManager.showProgressDialog(loadingFragment)
    }

    fun cancelProgressDialog() {
        supportFragmentManager.cancelProgressDialog()
    }

}