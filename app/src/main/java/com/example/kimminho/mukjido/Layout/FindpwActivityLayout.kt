package com.example.kimminho.mukjido.Layout

import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.kimminho.mukjido.Activity.FindpwActivity
import org.jetbrains.anko.*

class FindpwActivityLayout : AnkoComponent<FindpwActivity> {

    lateinit var findpwbackButton: Button
    lateinit var topBar: TextView

    lateinit var sign_in_email: TextView
    lateinit var sign_in_password : TextView

    lateinit var input_email: EditText
    lateinit var input_password: EditText

    lateinit var findpw_button: Button

    override fun createView(ui: AnkoContext<FindpwActivity>) = with(ui) {
        verticalLayout {

            relativeLayout {
                findpwbackButton = button("<") {
                    textSize = 25f
                    backgroundColor = Color.alpha(0)
                    textColor = Color.BLACK
                }.lparams(150, 150)
                topBar = textView {
                    text = "비밀번호 찾기"
                    textSize = 25f
                    textColor = Color.BLACK
                    gravity = Gravity.CENTER
                }.lparams(matchParent){ margin = dip(15)}
            }.lparams()
            verticalLayout {
                sign_in_email = textView {
                    text = "이메일"
                    textSize = 20f
                }
                input_email = editText(){
                    hint = "example@email.com"
                }.lparams(matchParent)
                findpw_button = button{
                    text = "이메일로 재설정 주소보내기"
                    textSize = 20f
                    backgroundColor = Color.LTGRAY

                }.lparams(matchParent){margin = dip(30)}
            }
        }
    }
}