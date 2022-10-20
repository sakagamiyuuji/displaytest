package com.test.asahpolapikir.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.test.asahpolapikir.app.databinding.FragmentComingSoonBinding
import com.test.asahpolapikir.core.view.base.BaseFragment

class InboxFragment : BaseFragment<FragmentComingSoonBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): FragmentComingSoonBinding {
        return FragmentComingSoonBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): InboxFragment =
            InboxFragment().apply {
                val bundle = Bundle()
                arguments = bundle
            }
    }

}