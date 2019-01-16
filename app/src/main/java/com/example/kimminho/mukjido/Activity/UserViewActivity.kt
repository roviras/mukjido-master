package com.example.kimminho.mukjido.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.kimminho.mukjido.Fragment.*
import com.example.kimminho.mukjido.Layout.UserViewActivityLayout
import org.jetbrains.anko.setContentView


import java.util.ArrayList


class UserViewActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = UserViewActivityLayout()
        layout.setContentView(this)

        setupViewPager(layout.vp)
        layout.tabLayout.setupWithViewPager(layout.vp)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ComFragment(), "대동먹지도")
        adapter.addFragment(Mymukmap(), "내먹지도")
        adapter.addFragment(Mymukposts(), "내먹부림")
        adapter.addFragment(Setting(),"설정")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }
}






