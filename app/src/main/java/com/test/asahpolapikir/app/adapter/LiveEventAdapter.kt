package com.test.asahpolapikir.app.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.test.asahpolapikir.app.databinding.AdapterFullBannerBinding
import com.test.asahpolapikir.app.databinding.AdapterLiveEventBinding
import com.test.asahpolapikir.app.databinding.AdapterSliderHorizontalContentBinding
import com.test.asahpolapikir.core.view.base.BaseBindingAdapter
import com.test.asahpolapikir.core.view.base.BaseBindingViewHolder

class LiveEventAdapter() : BaseBindingAdapter<BaseBindingViewHolder>() {

    var listItems = mutableListOf<Int?>()
    var onClick: ((deeplink: String) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: List<Int?>) {
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
        return BaseBindingViewHolder(
            AdapterLiveEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun updateBinding(holder: BaseBindingViewHolder, binding: ViewBinding, position: Int) {
        val bind = binding as AdapterLiveEventBinding
        val data = listItems[position]

        Glide.with(context)
            .load(data)
            .fitCenter()
            .into(bind.ivNewBanner)
    }
}