package com.dcom.triviandroid.activities.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.dcom.triviandroid.R
import com.dcom.triviandroid.activities.results.ResultActivity
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

        val stringQ1: String = getString(R.string.question_1)
        val stringQ2: String = getString(R.string.question_2)
        val stringQ3: String = getString(R.string.question_3)

        val stringOp1Q2: String = getString(R.string.option_1Q2)
        val stringOp2Q2: String = getString(R.string.option_2Q2)
        val stringOp3Q2: String = getString(R.string.option_3Q2)

        val stringOp1Q3: String = getString(R.string.option_1Q3)
        val stringOp2Q3: String = getString(R.string.option_2Q3)
        val stringOp3Q3: String = getString(R.string.option_3Q3)

        binding = DataBindingUtil.setContentView<ActivityQuestionsBinding>(this,
            R.layout.activity_questions)

        val quizList1 = mutableListOf<Question1>(
            Question1(stringQ1,
                "onCreate(), onCreateView(), onStart()",
                "onPush(), onLaunch(), onGo()",
                "onFragment(), onRun(), onPause()")
        )

        val quizList2 = mutableListOf<Question2>(
            Question2(stringQ2,
                stringOp1Q2,
                stringOp2Q2,
                stringOp3Q2)
        )

        val quizList3 = mutableListOf<Question3>(
            Question3(stringQ3,
                stringOp1Q3,
                stringOp2Q3,
                stringOp3Q3)
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
                        question +=1
                        finish()
                        val intent = Intent(this, ResultActivity::class.java).apply {
                            putExtra("score", score.toString())
                            putExtra("name", name)
                        }
                        startActivity(intent)

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
                        question +=1
                        finish()
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
                        question +=1
                        finish()
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





