package com.example.kimminho.mukjido.Layout

import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.kimminho.mukjido.Activity.SigninActivity
import org.jetbrains.anko.*

class SigninActivityLayout : AnkoComponent<SigninActivity> {

    lateinit var SigninbackButton: Button
    lateinit var topBar: TextView

    lateinit var sign_in_email: TextView
    lateinit var sign_in_password : TextView

    lateinit var input_email:EditText
    lateinit var input_password:EditText

    lateinit var log_in_button:Button

    override fun createView(ui: AnkoContext<SigninActivity>) = with(ui) {
        verticalLayout {

            relativeLayout {
                SigninbackButton = button("<") {
                    textSize = 25f
                    backgroundColor = Color.alpha(0)
                    textColor = Color.BLACK
                }.lparams(150, 150)
                topBar = textView {
                    text = "로그인"
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
                sign_in_password = textView {
                    text = "비밀번호"
                    textSize = 20f
                }
                input_password = editText(){
                    hint = "password"
                }.lparams(matchParent)
                log_in_button = button{
                    text = "로그인"
                    textSize = 20f
                    backgroundColor = Color.LTGRAY
                    
                }.lparams(matchParent){margin = dip(30)}
            }
        }
    }
}