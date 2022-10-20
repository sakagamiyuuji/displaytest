package com.test.asahpolapikir.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.test.asahpolapikir.app.databinding.AdapterFeatureBinding
import com.test.asahpolapikir.app.model.Feature
import com.test.asahpolapikir.core.view.base.BaseBindingAdapter
import com.test.asahpolapikir.core.view.base.BaseBindingViewHolder

class FeatureAdapter: BaseBindingAdapter<BaseBindingViewHolder>() {

    private val listItems = mutableListOf<Feature>()
    val onClick: ((url: String) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: List<Feature>) {
        listItems.clear()
        listItems.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        listItems.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        return BaseBindingViewHolder(AdapterFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun updateBinding(holder: BaseBindingViewHolder, binding: ViewBinding, position: Int) {
        val bind = binding as AdapterFeatureBinding
        val data = listItems[position]

        bind.ivIcon.setImageResource(data.image)
        bind.tvTitle.text = data.title
    }

}