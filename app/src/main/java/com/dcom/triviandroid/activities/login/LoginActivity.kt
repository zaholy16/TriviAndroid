package com.dcom.triviandroid.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.dcom.triviandroid.R
import com.dcom.triviandroid.activities.questions.QuestionsActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val nameLogin = findViewById<EditText>(R.id.name)
        val name = nameLogin.text

        buttonLogin.setOnClickListener(){

            if (nameLogin.text.isEmpty())
                Toast.makeText(this, "Put your name please :)", Toast.LENGTH_LONG).show()
            else{
                val intent = Intent(this, QuestionsActivity::class.java).apply {
                    putExtra("name", name.toString())
                }
                startActivity(intent)
            }
        }
    }
}