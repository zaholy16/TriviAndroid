package com.dcom.triviandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.dcom.triviandroid.R
import com.dcom.triviandroid.activities.questions.QuestionsActivity
import com.dcom.triviandroid.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val playAgain = findViewById<Button>(R.id.play_again)
        val binding = DataBindingUtil.setContentView<ActivityResultBinding>(this, R.layout.activity_result)
        val bundle: Bundle? = intent.extras

        if(bundle!=null){

            val score: String = bundle.getString("score")?:"nada"
            binding.result.text = score

            val name: String = bundle.getString("name")?:"nada"
            binding.nameResult.text = name
        }

        playAgain.setOnClickListener(){
            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)
        }
    }
}