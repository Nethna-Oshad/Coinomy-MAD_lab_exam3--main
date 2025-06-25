package com.example.coinomy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PasscodeActivity : AppCompatActivity() {
    private lateinit var passcodeDisplay: TextView
    private var enteredPasscode = ""
    private val correctPasscode = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passcode)

        passcodeDisplay = findViewById(R.id.passcodeDisplay)

        // Set up number buttons
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button$i", "id", packageName)
            findViewById<Button>(buttonId).setOnClickListener {
                if (enteredPasscode.length < 4) {
                    enteredPasscode += i.toString()
                    updatePasscodeDisplay()
                }
            }
        }

        // Set up clear button
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            enteredPasscode = ""
            updatePasscodeDisplay()
        }

        // Set up enter button
        findViewById<Button>(R.id.buttonEnter).setOnClickListener {
            if (enteredPasscode == correctPasscode) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrect passcode", Toast.LENGTH_SHORT).show()
                enteredPasscode = ""
                updatePasscodeDisplay()
            }
        }
    }

    private fun updatePasscodeDisplay() {
        val displayText = "*".repeat(enteredPasscode.length)
        passcodeDisplay.text = displayText
    }
} 