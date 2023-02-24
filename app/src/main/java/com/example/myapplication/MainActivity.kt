package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val maxQuestionsQuantity = 10
    private var questionsQuantity:Int = 1

    private lateinit var etName: EditText
    private lateinit var btnStart: Button

    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var tvQuestionsCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        btnStart.setOnClickListener {
            if (etName.text.isNotEmpty() && questionsQuantity > 0) {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                intent.putExtra(Constants.QUESTIONS_QUANTITY, questionsQuantity)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
            }
        }

        changeQuestionsQuantity()

    }


    fun changeQuestionsQuantity() {
        btnLeft.setOnClickListener {
            if (questionsQuantity == 1) {
                Toast.makeText(this, "You've already chose min amount of questions", Toast.LENGTH_LONG).show()
            } else {
               questionsQuantity--
                tvQuestionsCount.text = "$questionsQuantity/$maxQuestionsQuantity"
            }
        }


        btnRight.setOnClickListener {

            if (questionsQuantity == maxQuestionsQuantity) {
                Toast.makeText(this, "You've already chose max amount of questions", Toast.LENGTH_LONG).show()
            }

            else
            {
                questionsQuantity++
                tvQuestionsCount.text = "$questionsQuantity/$maxQuestionsQuantity"
            }
        }
    }


    fun initialize() {
        etName = findViewById(R.id.etNameField)
        btnStart = findViewById(R.id.btnStart)

        btnLeft = findViewById(R.id.btnLeftArrow)
        btnRight = findViewById(R.id.btnRightArrow)
        tvQuestionsCount = findViewById(R.id.questionsCount)

    }
}