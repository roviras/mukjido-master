package com.example.kimminho.mukjido.Layout

import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.kimminho.mukjido.Activity.SignupActivity
import org.jetbrains.anko.*

class SignupActivityLayout : AnkoComponent<SignupActivity> {

    lateinit var SignupbackButton: Button
    lateinit var topBar: TextView

    lateinit var sign_up_email: TextView
    lateinit var sign_up_password : TextView
    lateinit var sign_up_confirm_password : TextView

    lateinit var input_email: EditText
    lateinit var input_password: EditText
    lateinit var input_confirm_password :EditText

    lateinit var log_up_button: Button


    override fun createView(ui: AnkoContext<SignupActivity>) = with(ui) {
        verticalLayout {

            relativeLayout {
                SignupbackButton = button("<") {
                    textSize = 25f
                    backgroundColor = Color.alpha(0)
                    textColor = Color.BLACK
                }.lparams(150, 150)
                topBar = textView {
                    text = "회원가입"
                    textSize = 25f
                    textColor = Color.BLACK
                    gravity = Gravity.CENTER
                }.lparams(matchParent){ margin = dip(15)}
            }.lparams()
            verticalLayout {
                sign_up_email = textView {
                    text = "이메일"
                    textSize = 20f
                }
                input_email = editText(){
                    hint = "example@email.com"
                    textSize = 20f
                }.lparams(matchParent)
                sign_up_password = textView {
                    text = "비밀번호"
                    textSize = 20f
                }
                input_password = editText(){
                    hint = "password"
                    textSize = 20f
                }.lparams(matchParent)
                sign_up_confirm_password = textView {
                    text = "비밀번호 확인"
                    textSize = 20f
                }
                input_confirm_password = editText {
                    hint = "confirm Password"
                    textSize = 20f
                }

                log_up_button = button{
                    text = "로그인"
                    textSize = 20f
                    backgroundColor = Color.LTGRAY

                }.lparams(matchParent){margin = dip(30)}
            }
        }
    }
}