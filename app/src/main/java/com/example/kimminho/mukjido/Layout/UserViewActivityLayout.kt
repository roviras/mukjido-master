package com.example.kimminho.mukjido.Layout


import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.text.Layout
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TextView
import com.example.kimminho.mukjido.Activity.UserViewActivity
import com.example.kimminho.mukjido.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4.viewPager

class UserViewActivityLayout : AnkoComponent<UserViewActivity> {

    lateinit var vp: ViewPager
    lateinit var tabLayout : TabLayout
    lateinit var textView: TextView
    override fun createView(ui: AnkoContext<UserViewActivity>) = with(ui) {

            coordinatorLayout {


                themedAppBarLayout {

                    textView = textView {
                        text = "먹지도"
                        textSize = 25f
                        Gravity.CENTER_VERTICAL
                    }.lparams(matchParent, wrapContent)

                    tabLayout = tabLayout {


                    }.lparams(matchParent, wrapContent)


                }.lparams(matchParent, wrapContent)

                vp = viewPager {
                    id = R.id.container
                }.lparams(matchParent, matchParent) {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }


            }

    }
}