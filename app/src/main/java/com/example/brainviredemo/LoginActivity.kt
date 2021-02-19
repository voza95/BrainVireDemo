package com.example.brainviredemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import com.example.brainviredemo.util.AppUtil

class LoginActivity : AppCompatActivity() {

    lateinit var etEmail: AppCompatEditText
    lateinit var etPassword: AppCompatEditText
    lateinit var btnLogin: Button
    lateinit var rlForm: LinearLayout

    var userEmail:String = ""
    var userPwd: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()

        btnLogin.setOnClickListener {
            userEmail = etEmail.text.toString().trim()
            userPwd = etPassword.text.toString()

            if (checkData()){
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    fun initViews(){
        rlForm = findViewById(R.id.rlForm)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun checkData(): Boolean{
        if (userEmail.isEmpty()){
            AppUtil.onDispalySnack(
                rlForm,
                "Please enter your email address",
                this@LoginActivity
            )
            return false
        }
        if (!AppUtil.isEmailValid(userEmail)){
            AppUtil.onDispalySnack(
                rlForm,
                "Please enter a valid Email-Id",
                this@LoginActivity
            )
            return false
        }

        if (userPwd.isEmpty()){
            AppUtil.onDispalySnack(
                rlForm,
                "Please enter password",
                this@LoginActivity
            )
            return false
        }

        if (userEmail != "test@android.com"){
            AppUtil.onDispalySnack(
                rlForm,
                "Wrong email address",
                this@LoginActivity
            )
            return false
        }
        if (userPwd != "123456"){
            AppUtil.onDispalySnack(
                rlForm,
                "Wrong email address",
                this@LoginActivity
            )
            return false
        }
        return true
    }
}