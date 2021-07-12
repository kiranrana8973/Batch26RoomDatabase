package com.kiran.batch26roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var etFname: EditText
    private lateinit var etLname: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnAddStudent: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFname = findViewById(R.id.etFname)
        etLname = findViewById(R.id.etLname)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnAddStudent = findViewById(R.id.btnAddStudent)

        btnAddStudent.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {
        val fname = etFname.text.toString()
        val lname = etLname.text.toString()
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()


        if (password != confirmPassword) {
            etPassword.error = "Password does not match"
            etPassword.requestFocus()
            return
        } else {
            //Insert user to Room database


        }
    }
}
