package com.mobile.uts_desvitaputri

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPageActivity : AppCompatActivity() {
    private lateinit var btnLogin2 : Button
    private lateinit var txtSignUp: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        btnLogin2 = findViewById(R.id.btnLogin2)
        txtSignUp = findViewById(R.id.txtLogin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtSignUp.setOnClickListener() {
            val intentPassingData = Intent(this, PageRegister::class.java)
            startActivity(intentPassingData)
        }

        btnLogin2.setOnClickListener() {
            val intentPassingData = Intent(this, RecycleMakanan::class.java)
            startActivity(intentPassingData)
        }
    }
}