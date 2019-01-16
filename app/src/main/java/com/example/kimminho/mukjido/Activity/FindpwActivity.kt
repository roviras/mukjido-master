package com.example.kimminho.mukjido.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kimminho.mukjido.Layout.FindpwActivityLayout
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class FindpwActivity : AppCompatActivity(){

    private lateinit var mAuth: FirebaseAuth

    private var findpwActivityLayout = FindpwActivityLayout()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        findpwActivityLayout.apply {
            setContentView(this@FindpwActivity)


            findpwbackButton.setOnClickListener() {
                val backIntent = Intent(this@FindpwActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
            findpw_button.setOnClickListener {
                val email = input_email.text?.toString()

                if (email.isNullOrBlank()) {
                    toast("정보를 입력해주세요.")
                    return@setOnClickListener
                }

                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(){task ->
                        if(task.isSuccessful){
                            val firebaseUser = mAuth.currentUser
                            toast("이메일을 확인해주세요")
                        }else{
                            task.exception!!.printStackTrace()
                            toast("존재하지않는 아이디 입니다")
                        }
                    }
            }
        }
    }
}