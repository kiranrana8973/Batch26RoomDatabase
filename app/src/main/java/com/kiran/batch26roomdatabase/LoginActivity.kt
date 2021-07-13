package com.kiran.batch26roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.kiran.batch26roomdatabase.db.StudentDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var tvRegister: TextView
    private lateinit var btnLogin: Button
    private lateinit var chkRememberMe: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)
        chkRememberMe = findViewById(R.id.chkRememberMe)

        tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }


        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
            val user = StudentDB.getInstance(this@LoginActivity)
                .getUserDAO().checkUser(username, password)

            if(user == null){
                withContext(Main){
                    Toast.makeText(this@LoginActivity, "Either usename or password is incorrect", Toast.LENGTH_SHORT).show()
                }
            }else{
                startActivity(Intent(
                    this@LoginActivity,
                    DashboardActivity::class.java
                ))
            }

        }
    }
}