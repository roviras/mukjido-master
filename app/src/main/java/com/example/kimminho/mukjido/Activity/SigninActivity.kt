package com.example.kimminho.mukjido.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kimminho.mukjido.Layout.SigninActivityLayout
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class SigninActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    private var signinActivityLayout = SigninActivityLayout()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        signinActivityLayout.apply {
            setContentView(this@SigninActivity)
            SigninbackButton.setOnClickListener() {
                val backIntent = Intent(this@SigninActivity, MainActivity::class.java)
                startActivity(backIntent)
            }

            log_in_button.setOnClickListener {
                val email = input_email.text?.toString()
                val password = input_password.text?.toString()

                if (email.isNullOrBlank() || password.isNullOrBlank()) {
                    toast("정보를 입력해주세요.")
                    return@setOnClickListener
                }

                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task: Task<AuthResult> ->
                        if (task.isSuccessful) {
                            val toast = toast("로그인 성공")
                            val firebaseUser = mAuth.currentUser
                            val loginsuccess = Intent(this@SigninActivity, UserViewActivity::class.java)
                            startActivity(loginsuccess)
                        }else{
                            task.exception!!.printStackTrace()
                            toast("로그인실패")
                        }
                    }
            }
        }
    }
}