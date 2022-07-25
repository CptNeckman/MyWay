package com.example.myway.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.myway.R
import java.util.prefs.Preferences

class WelcomeActivity : AppCompatActivity() {

    lateinit var buttonStart: Button
    lateinit var etUserName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        buttonStart = findViewById(R.id.buttonStart)
        etUserName = findViewById(R.id.editTextUserName)

        buttonStart.setOnClickListener {
            startMainActivity()
        }

        etUserName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                buttonStart.isEnabled = text?.length != 0
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun startMainActivity() {
        val userName = etUserName.text.toString()
        saveName(userName)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saveName(userName: String) {
        USER_NAME = userName
    }

    companion object {
        var USER_NAME = "UserName"
    }
}