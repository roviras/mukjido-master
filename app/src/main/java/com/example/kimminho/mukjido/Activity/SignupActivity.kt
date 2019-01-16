package com.example.kimminho.mukjido.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kimminho.mukjido.Layout.SignupActivityLayout
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class SignupActivity : AppCompatActivity() {


    private lateinit var mAuth: FirebaseAuth

    private var signupActivityLayout = SignupActivityLayout()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        signupActivityLayout.apply {
            setContentView(this@SignupActivity)
            SignupbackButton.setOnClickListener {
                val backIntent = Intent(this@SignupActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
            log_up_button.setOnClickListener {

                val email = input_email.text?.toString()
                val password = input_password.text?.toString()

                if (email.isNullOrBlank() || password.isNullOrBlank()) {
                    toast("정보를 입력해주세요.")
                    return@setOnClickListener
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task: Task<AuthResult> ->
                        if (task.isSuccessful) {
                            val firebaseUser = mAuth.currentUser
                            toast("회원가입 성공")
                            val logupsuccess = Intent(this@SignupActivity,
                                UserViewActivity::class.java)
                            startActivity(logupsuccess)
                        } else {
                            task.exception!!.printStackTrace()
                            toast("회원가입실패")
                        }
                    }

            }
        }


    }
}
