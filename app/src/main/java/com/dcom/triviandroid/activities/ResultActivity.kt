package com.dcom.triviandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.dcom.triviandroid.R
import com.dcom.triviandroid.activities.login.LoginActivity
import com.dcom.triviandroid.activities.questions.QuestionsActivity
import com.dcom.triviandroid.databinding.ActivityLoginBinding
import com.dcom.triviandroid.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val binding = DataBindingUtil.setContentView<ActivityResultBinding>(this, R.layout.activity_result)
        val bundle: Bundle? = intent.extras
        val stringResult: String = getString(R.string.result_result)


        if(bundle!=null){

            val score: String = bundle.getString("score")?:"nada"
            binding.result.text = stringResult + score

            val name: String = bundle.getString("name")?:"nada"
            binding.nameResult.text = name

            binding.logOut.setOnClickListener(){
                finish()
                val intent2= Intent(this, LoginActivity::class.java)
                startActivity(intent2)
            }

            binding.playAgain.setOnClickListener(){
                finish()
                val intent= Intent(this, QuestionsActivity::class.java).apply {
                    putExtra("name", name)
                }
                startActivity(intent)
            }
        }
    }
    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}