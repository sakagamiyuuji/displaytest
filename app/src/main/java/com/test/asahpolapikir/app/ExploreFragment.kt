package com.test.asahpolapikir.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.test.asahpolapikir.app.adapter.CustomBannerAdapter
import com.test.asahpolapikir.app.adapter.LiveEventAdapter
import com.test.asahpolapikir.app.adapter.YourChoiceAdapter
import com.test.asahpolapikir.app.databinding.FragmentExploreBinding
import com.test.asahpolapikir.core.view.base.BaseFragment
import com.test.asahpolapikir.core.view.extensions.dp

class ExploreFragment : BaseFragment<FragmentExploreBinding>() {

    private val yourChoiceAdapter by lazy { YourChoiceAdapter() }
    private val recommendedAdapter by lazy { YourChoiceAdapter() }
    private val liveEventAdapter by lazy { LiveEventAdapter() }
    private val customBannerAdapter by lazy { CustomBannerAdapter(requireContext()) }

    override fun setBinding(layoutInflater: LayoutInflater): FragmentExploreBinding {
        return FragmentExploreBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAdapter()

    }

    private fun initView() {
        binding.ivCloseMessage.setOnClickListener { showToast("You can't close this message") }
    }

    private fun initAdapter() {
        initBannerAdapter()
        initYourChoiceAdapter()
        initRecommendedAdapter()
        initLiveEventAdapter()
    }

    private fun initBannerAdapter() {
        val listBanner = listOf(
            ContextCompat.getDrawable(requireContext(), com.myultimate.core.view.R.drawable.img_sample_banner_1),
            ContextCompat.getDrawable(requireContext(), com.myultimate.core.view.R.drawable.img_sample_banner_1),
            ContextCompat.getDrawable(requireContext(), com.myultimate.core.view.R.drawable.img_sample_banner_1)
        )

        binding.vpTopBanner.adapter = customBannerAdapter
        binding.vpTopBanner.setPadding(10.dp, 0.dp, 10.dp, 0.dp)
        binding.vpTopBanner.pageMargin = 12.dp
        customBannerAdapter.addItems(listBanner)
        binding.vpTopBanner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                binding.pageIndicatorView.selection = position
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
        binding.pageIndicatorView.clearFocus()
    }

    private fun initYourChoiceAdapter() {
        binding.ivDetailYourChoice.setOnClickListener {
            showToast("Your choice details coming soon")
        }
        binding.rvYourChoice.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvYourChoice.adapter = yourChoiceAdapter
        yourChoiceAdapter.addItems(listOf(
            com.myultimate.core.view.R.drawable.image_sample_1,
            com.myultimate.core.view.R.drawable.image_sample_2,
            com.myultimate.core.view.R.drawable.image_sample_3,
            com.myultimate.core.view.R.drawable.image_sample_4
        ))
    }

    private fun initRecommendedAdapter() {
        binding.ivDetailRecommended.setOnClickListener {
            showToast("Your recommended videos coming soon")
        }
        binding.rvRecommended.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvRecommended.adapter = recommendedAdapter
        recommendedAdapter.addItems(listOf(
            com.myultimate.core.view.R.drawable.image_sample_3,
            com.myultimate.core.view.R.drawable.image_sample_4,
            com.myultimate.core.view.R.drawable.image_sample_1,
            com.myultimate.core.view.R.drawable.image_sample_2
        ))
    }

    private fun initLiveEventAdapter() {
        binding.ivDetailLiveEvent.setOnClickListener {
            showToast("Your nearest live event coming soon")
        }
        binding.rvLiveEvent.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvLiveEvent.adapter = liveEventAdapter
        liveEventAdapter.addItems(listOf(
            com.myultimate.core.view.R.drawable.img_sample_banner_2,
            com.myultimate.core.view.R.drawable.img_sample_banner_1,
            com.myultimate.core.view.R.drawable.image_sample_4,
            com.myultimate.core.view.R.drawable.image_sample_2
        ))
    }

    companion object {
        fun newInstance(): ExploreFragment =
            ExploreFragment().apply {
                val bundle = Bundle()
                arguments = bundle
            }
    }

}