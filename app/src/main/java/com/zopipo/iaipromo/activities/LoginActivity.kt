package com.zopipo.iaipromo.activities

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zopipo.iaipromo.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        val passwordEt = findViewById<EditText>(R.id.passwordEt)
        val identifiantEt = findViewById<EditText>(R.id.identifiantEt)
        val apercuPasswordCb = findViewById<CheckBox>(R.id.apercuPasswordCb)
        val loginAccountBtn = findViewById<Button>(R.id.loginAccountBtn)
        val createAccountBtn = findViewById<Button>(R.id.createAccountBtn)
        val passwordForgetBtn = findViewById<Button>(R.id.passwordForgetBtn)
        val couvertureIv = findViewById<ImageView>(R.id.imageView)

        apercuPasswordCb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                passwordEt.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                passwordEt.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            passwordEt.setSelection(passwordEt.text.length)
        }

        loginAccountBtn.setOnClickListener{
            val identifiant = identifiantEt.text.toString()
            val password = passwordEt.text.toString()

        }

        createAccountBtn.setOnClickListener{
            Intent(this, AccountActivity::class.java).also {
                startActivity(it)
            }
        }

        passwordForgetBtn.setOnClickListener{

            Intent(this, ChangePasswordActivity::class.java).also{

                startActivity(it)
            }
        }
    }
}