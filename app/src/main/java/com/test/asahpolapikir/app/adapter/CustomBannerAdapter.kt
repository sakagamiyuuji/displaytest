package com.test.asahpolapikir.app.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.test.asahpolapikir.app.R

class CustomBannerAdapter(
    private val context: Context
): PagerAdapter() {

    var listItems = mutableListOf<Drawable?>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: List<Drawable?>) {
        listItems.clear()
        listItems.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        listItems.clear()
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return listItems.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.adapter_full_banner, null)

        val banner = listItems[position]

        Glide.with(view.context)
            .load(banner)
            .fitCenter()
            .into(view.findViewById(R.id.iv_new_banner))

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}