package com.test.asahpolapikir.core.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.test.asahpolapikir.core.view.extensions.getColorRes
import com.myultimate.core.view.view.loading.LoadingFragment
import com.myultimate.core.view.view.loading.cancelProgressDialog
import com.myultimate.core.view.view.loading.showProgressDialog

/**
 * Created by Hans on 19/10/22.
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected open lateinit var binding: VB

    private var loadingFragment: LoadingFragment? = null

    abstract fun setBinding(layoutInflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setBinding(inflater)
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(requireContext(), msg, duration).show()
    }

    fun showProgressDialog() {
        activity?.supportFragmentManager?.showProgressDialog(loadingFragment)
    }

    fun cancelProgressDialog() {
        activity?.supportFragmentManager?.cancelProgressDialog()
    }

    fun getColor(colorResId: Int): Int {
        return requireContext().getColorRes(colorResId)
    }

}