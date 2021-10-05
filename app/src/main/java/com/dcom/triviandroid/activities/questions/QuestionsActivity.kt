package com.dcom.triviandroid.activities.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dcom.triviandroid.R
import com.dcom.triviandroid.activities.ResultActivity
import com.dcom.triviandroid.databinding.ActivityQuestionsBinding
import com.dcom.triviandroid.models.*

class QuestionsActivity : AppCompatActivity() {

    companion object {
        const val SCORE_KEY = "score_key"
    }

    private lateinit var binding: ActivityQuestionsBinding
    private var question: Int = 1
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        binding = DataBindingUtil.setContentView<ActivityQuestionsBinding>(this,
            R.layout.activity_questions)

        val quizList1 = mutableListOf<Question1>(
            Question1("¿Comida favorita?", "Sopas", "Tacos", "Tamales")
        )

        val quizList2 = mutableListOf<Question2>(
            Question2("¿Musica favorita?", "Ranchero", "Kpop", "Rock")
        )

        val quizList3 = mutableListOf<Question3>(
            Question3("¿Color favorito?", "Negro", "Blanco", "Azul")
        )

        val bundle: Bundle? = intent.extras
        if (bundle != null) {

            val name: String = bundle.getString("name") ?: "nada"
            Log.i("mz", "${name}")

            binding.question.text = quizList1[0].question1
            binding.option1.text = quizList1[0].option1
            binding.option2.text = quizList1[0].option2
            binding.option3.text = quizList1[0].option3

            binding.currentQuestion.text = question.toString() + " / 3 "

            binding.option1.setOnClickListener() {
                when (question) {
                    1 -> {
                        score += 1
                        question += 1

                        binding.question.text = quizList2[0].question2
                        binding.option1.text = quizList2[0].option1
                        binding.option2.text = quizList2[0].option2
                        binding.option3.text = quizList2[0].option3

                        binding.currentQuestion.text = question.toString() + " / 3 "
                    }
                    2 -> {
                        question += 1

                        binding.question.text = quizList3[0].question3
                        binding.option1.text = quizList3[0].option1
                        binding.option2.text = quizList3[0].option2
                        binding.option3.text = quizList3[0].option3

                        binding.currentQuestion.text = question.toString() + " / 3 "
                    }
                    else -> {
                        question += 1
                        val intent = Intent(this, ResultActivity::class.java).apply {
                            putExtra("score", score.toString())
                            putExtra("name", name)
                        }
                        startActivity(intent)
                        finish()
                    }
                }
            }

            binding.option2.setOnClickListener() {
                when (question) {
                    1 -> {
                        question += 1

                        binding.question.text = quizList2[0].question2
                        binding.option1.text = quizList2[0].option1
                        binding.option2.text = quizList2[0].option2
                        binding.option3.text = quizList2[0].option3

                        binding.currentQuestion.text = question.toString() + " / 3 "
                    }
                    2 -> {
                        score+=1
                        question += 1

                        binding.question.text = quizList3[0].question3
                        binding.option1.text = quizList3[0].option1
                        binding.option2.text = quizList3[0].option2
                        binding.option3.text = quizList3[0].option3

                        binding.currentQuestion.text = question.toString() + " / 3 "
                    }
                    else -> {
                        question += 1
                        val intent = Intent(this, ResultActivity::class.java).apply {
                            putExtra("score", score.toString())
                            putExtra("name", name)
                        }
                        startActivity(intent)
                    }
                }
            }

            binding.option3.setOnClickListener{
                when (question) {
                    1 -> {
                        question += 1
                        binding.question.text = quizList2[0].question2
                        binding.option1.text = quizList2[0].option1
                        binding.option2.text = quizList2[0].option2
                        binding.option3.text = quizList3[0].option3

                        binding.currentQuestion.text = question.toString() + " / 3 "
                    }
                    2 -> {
                        question += 1
                        binding.question.text = quizList3[0].question3
                        binding.option1.text = quizList3[0].option1
                        binding.option2.text = quizList3[0].option2
                        binding.option3.text = quizList3[0].option3

                        binding.currentQuestion.text = question.toString() + " / 3 "
                    }
                    else -> {
                        score+=1
                        question += 1
                        val intent = Intent(this, ResultActivity::class.java).apply {
                            putExtra("score", score.toString())
                            putExtra("name", name)
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}





