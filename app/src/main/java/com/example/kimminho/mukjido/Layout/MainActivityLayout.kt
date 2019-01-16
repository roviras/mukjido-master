package com.example.kimminho.mukjido.Layout

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.*
import com.example.kimminho.mukjido.Activity.MainActivity
import org.jetbrains.anko.*

class MainActivityLayout : AnkoComponent<MainActivity> {

    lateinit var mainTextView: TextView
    lateinit var sign_in: Button
    lateinit var sign_up: Button
    lateinit var find_password : Button
    lateinit var backgroundView: ImageView

    var imageViewList = arrayListOf<ImageView>()


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {

            backgroundView = imageView{

                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams(matchParent, matchParent){

            }


            verticalLayout {

                mainTextView = textView(){
                    text="나만의 특별한 맛집 지도\n만들어 보세요"
                    textSize = 25f
                    textColor = Color.WHITE
                }.lparams(){margin=dip(15)}

            }.lparams(matchParent,500){centerInParent()}

            relativeLayout {
                verticalLayout {


                    sign_in = button("이메일로 로그인하기") {

                        textSize = 18f
                        backgroundTintList = ColorStateList.valueOf(Color.WHITE)
                    }
                    sign_up = button("간편 회원가입") {

                        textSize = 18f
                        backgroundTintList = ColorStateList.valueOf(Color.WHITE)
                    }
                    find_password = button("비밀번호 찾기") {

                        textSize = 18f
                        backgroundTintList = ColorStateList.valueOf(Color.WHITE)
                    }
                }.lparams(matchParent,500) {margin = dip(15)}

            }.lparams(matchParent){alignParentBottom()}
        }
    }
}