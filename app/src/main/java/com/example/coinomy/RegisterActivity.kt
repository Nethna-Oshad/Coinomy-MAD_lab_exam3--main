package com.example.coinomy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerUsernameEditText: EditText
    private lateinit var registerPasswordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerSubmitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerUsernameEditText = findViewById(R.id.registerUsernameEditText)
        registerPasswordEditText = findViewById(R.id.registerPasswordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)
        registerSubmitButton = findViewById(R.id.registerSubmitButton)

        registerSubmitButton.setOnClickListener {
            val username = registerUsernameEditText.text.toString()
            val password = registerPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // For demo purposes, we'll just show a success message and go back to login
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
} 