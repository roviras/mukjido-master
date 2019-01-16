package com.example.kimminho.mukjido.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kimminho.mukjido.Layout.MainActivityLayout
import com.google.firebase.auth.FirebaseAuth

import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {


    private val mainActivityLayout: MainActivityLayout by lazy { MainActivityLayout() }

    private lateinit var mAuth: FirebaseAuth
    //파이어베이스 연동  mAuth 변수에 프로퍼티 FirebaseAuth 초기화

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mainActivityLayout.setContentView(this)
        //mainActivityLayout 을 MainActivity 에 setContentView 해준다

        mAuth = FirebaseAuth.getInstance()
        // 변수 mAuth 에 FirebaseAuth 에서





        mainActivityLayout.apply {
            setContentView(this@MainActivity)

            sign_in.setOnClickListener {
                val nextIntent = Intent(this@MainActivity, SigninActivity::class.java)
                startActivity(nextIntent)
            }
            sign_up.setOnClickListener {
                val nextIntent = Intent(this@MainActivity, SignupActivity::class.java)
                startActivity(nextIntent)
            }
            find_password.setOnClickListener {
                val nextIntent = Intent(this@MainActivity, FindpwActivity::class.java)
                startActivity(nextIntent)
            }

            Glide.with(this@MainActivity)
                .load("https://postfiles.pstatic.net/MjAxODExMDFfMTE5/MDAxNTQxMDQ0MjMzMjEz.6SGkDwSTGL_gqpCAY9uZsq0G6SwCGci_R2gp8gSFY0og.px7Lm_zodxMx09Pvuth2FaDAdG7fHLwLBuT9uHfSgNwg.PNG.dbtjgk102/%EC%BA%A1%EC%B2%98.PNG?type=w773")
                .into(backgroundView)

        }
    }
}





