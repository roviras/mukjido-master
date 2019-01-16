package com.example.kimminho.mukjido.FragmentLayout

import android.content.Context
import android.widget.TextView

import org.jetbrains.anko.*


//class SettingLayout : AnkoComponent<Context>{
//
//    override fun createView(ui: AnkoContext<Context>)  = with(ui) {
//
//        frameLayout {
//
//        }
//
//    }
//
// }
//


class MymukpostsLayout : AnkoComponent<Context>{


    lateinit var username : TextView

    override fun createView(ui: AnkoContext<Context>) = with(ui) {

        scrollView {

            verticalLayout {
                username  = textView {
                    text = "HELLO KOTLIN"
                }.lparams(matchParent,200)

            }.lparams(matchParent, wrapContent)

        }
    }
}