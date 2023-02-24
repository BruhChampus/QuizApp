package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tvCongratulations: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvTimeSpent: TextView
    private lateinit var btnRetry: Button


    private var userName: String? = null
    private var time: String? = null
    private var questionsQuantity: Int = 0
    private var score: Int = 0

    private lateinit var msgCongratulations: String
    private lateinit var msgYourScore: String
    private lateinit var msgTimeSpent: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initialize()

        tvCongratulations.text = msgCongratulations
        tvScore.text = msgYourScore
        tvTimeSpent.text = msgTimeSpent

        btnRetry.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun initialize() {
        tvCongratulations = findViewById(R.id.tv_congratulations)
        tvScore = findViewById(R.id.tv_your_score)
        tvTimeSpent = findViewById(R.id.tv_time_spent)

        btnRetry = findViewById(R.id.btn_retry)

        userName = intent.getStringExtra(Constants.USER_NAME)
        time = intent.getStringExtra(Constants.TIME)
        questionsQuantity = intent.getIntExtra(Constants.QUESTIONS_QUANTITY, 0)
        score = intent.getIntExtra(Constants.SCORE, 0)


        msgCongratulations = "Congratulations, $userName. You've completed the quizz"
        msgYourScore = "Your score is: $score out of $questionsQuantity"
        msgTimeSpent = "Time spent: $time"
    }
}