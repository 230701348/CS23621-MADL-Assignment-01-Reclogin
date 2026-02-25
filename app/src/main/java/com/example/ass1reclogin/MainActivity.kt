package com.example.ass1reclogin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val validate=findViewById<Button>(R.id.validate)

        validate.setOnClickListener {
            val emails=email.text.toString().trim()
            val passwords=password.text.toString().trim()

            val emailpattern="^[A-Za-z0-9._%+-]+@rajalakshmi\\.edu\\.in$"
            val passwordpattern="^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{12,}$"

            if(emails.isEmpty()||passwords.isEmpty()){
                Toast.makeText(this,"Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }else if(!emails.matches(Regex(emailpattern))){
                email.error="Enter valid email (eg: user@rajalakshmi.edu.in)"
            }else if(!passwords.matches(Regex(passwordpattern))){
                password.error="Password must be min 12 char, atleast 1 upper, 1 number and 1 special char"
            }else{
                Toast.makeText(this,"Validation successful!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}