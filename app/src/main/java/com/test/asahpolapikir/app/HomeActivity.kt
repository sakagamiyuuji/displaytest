package com.test.asahpolapikir.app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.test.asahpolapikir.app.databinding.ActivityHomeBinding
import com.test.asahpolapikir.core.view.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private var homeFragment: ComingSoonFragment? = null
    private var exploreFragment: ExploreFragment? = null
    private var eventFragment: ComingSoonFragment? = null
    private var inboxFragment: ComingSoonFragment? = null
    private var profileFragment: ComingSoonFragment? = null

    override fun setBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
        initBottomNavigation()
    }

    private fun initFragment() {
//        if (homeFragment == null) homeFragment = ComingSoonFragment.newInstance()
        if (exploreFragment == null) exploreFragment = ExploreFragment.newInstance()
//        if (eventFragment == null) eventFragment = ComingSoonFragment.newInstance()
//        if (inboxFragment == null) inboxFragment = ComingSoonFragment.newInstance()
//        if (profileFragment == null) profileFragment = ComingSoonFragment.newInstance()
    }

    private fun initBottomNavigation() {
        with(binding.bottomNavigation) {
            isItemHorizontalTranslationEnabled = false
            itemIconTintList = null
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_home -> {
                        //homeFragment?.let { loadFragment(it, TAG_HOME) }
                        showToast("Home Page Coming Soon")
                        return@setOnItemSelectedListener true
                    }
                    R.id.nav_explore -> {
                        exploreFragment?.let { loadFragment(it, TAG_EXPLORE) }
                        return@setOnItemSelectedListener true
                    }
                    R.id.nav_event -> {
                        //eventFragment?.let { loadFragment(it, TAG_EVENT) }
                        showToast("Event Page Coming Soon")
                        return@setOnItemSelectedListener true
                    }

                    R.id.nav_inbox -> {
                        //inboxFragment?.let { loadFragment(it, TAG_INBOX) }
                        showToast("Inbox Page Coming Soon")
                        return@setOnItemSelectedListener true
                    }

                    R.id.nav_profile -> {
                        //profileFragment?.let { loadFragment(it, TAG_PROFILE) }
                        showToast("Profile Page Coming Soon")
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
            setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.nav_home -> {}
                    R.id.nav_explore -> {}
                    R.id.nav_event -> {}
                    R.id.nav_inbox -> {}
                    R.id.nav_profile -> {}
                }
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.nav_explore
    }

    private fun loadFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.executePendingTransactions()
        val transaction = supportFragmentManager.beginTransaction()
        val frag = supportFragmentManager.findFragmentByTag(tag)
        if (frag != null) {
            transaction.show(frag)
        } else {
            transaction.add(
                binding.flContainer.id,
                fragment,
                tag
            )
        }
       /* when (fragment) {
            *//*is ComingSoonFragment -> {
                supportFragmentManager.findFragmentByTag(TAG_HOME)
                    ?.let { transaction.hide(it) }
                supportFragmentManager.findFragmentByTag(TAG_HOME)?.let { transaction.hide(it) }
            }*//*
            is ExploreFragment -> {
                supportFragmentManager.findFragmentByTag(TAG_EXPLORE)
                    ?.let { transaction.hide(it) }
                supportFragmentManager.findFragmentByTag(TAG_EXPLORE)?.let { transaction.hide(it) }
            }
        }*/
        transaction.commitNow()
    }


    companion object {
        const val TAG_HOME = "HOME"
        const val TAG_EXPLORE = "EXPLORE"
        const val TAG_EVENT = "EVENT"
        const val TAG_INBOX = "INBOX"
        const val TAG_PROFILE = "PROFILE"
    }


}