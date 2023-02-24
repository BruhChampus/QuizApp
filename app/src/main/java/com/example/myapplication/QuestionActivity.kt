package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity(), View.OnClickListener {


    private var mUserName: String? = null
    private var mQuestionsQuantity: Int = 0
    private var mCurrentPostion: Int = 0
    private var mSelectedOptionPostion: Int = 0
    private var mScore: Int = 0
    private lateinit var mQuestionList: ArrayList<Question>


    private lateinit var cTime: Chronometer
    private lateinit var tvScore: TextView
    private lateinit var tvQuestionCount: TextView

    private lateinit var tvQuestion: TextView
    private lateinit var ivQuestionImage: ImageView

    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView

    private lateinit var btnSubmit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        initalize()
        mQuestionList = Constants.getQuestions(mQuestionsQuantity)
        setQuestion()



        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)


        //Starting chronometer
        cTime.start()


    }


    private fun setQuestion() {
        val question: Question = mQuestionList[mCurrentPostion]

        tvQuestionCount.text = "${mCurrentPostion + 1}/${mQuestionList.size}"
        tvQuestion.text = question.question
        ivQuestionImage.setImageResource(question.image)

        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

        setOptionClickable(true)

    }



    private fun defaultOptionView() {
        val options = ArrayList<TextView>()

        tvOptionOne.let {
            options.add(0, it)
        }

        tvOptionTwo.let {
            options.add(1, it)
        }

        tvOptionThree.let {
            options.add(2, it)
        }


        tvOptionFour.let {
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPostion = selectedOptionNum

        tv.setTextColor(Color.BLACK)
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> {
                    selectedOptionView(tvOptionOne, 1)
            }

            R.id.tv_option_two -> {
                    selectedOptionView(tvOptionTwo, 2)

            }

            R.id.tv_option_three -> {
                    selectedOptionView(tvOptionThree, 3)
            }

            R.id.tv_option_four -> {
                    selectedOptionView(tvOptionFour, 4)
            }

            R.id.btnSubmit -> {
                onClickSubmitBtn()
            }
        }
    }


    private fun onClickSubmitBtn() {
        if (mSelectedOptionPostion == 0) {
            mCurrentPostion++
            when {
                mCurrentPostion <= mQuestionList.size - 1 -> {
                    btnSubmit.text = "Submit"
                    setQuestion()
                    defaultOptionView()
                    tvScore.text = "Score - $mScore"
                }

                else -> {
                    cTime.stop()
                    goToTheResultActivity()
                }
            }
        }
        //////Start of else block
        else {
            val question = mQuestionList[mCurrentPostion]

            if (mSelectedOptionPostion != question.correctAnswer) {
                aswerView(mSelectedOptionPostion, R.drawable.wrong_answer_border_bg)
            }

            else mScore++


            aswerView(question.correctAnswer, R.drawable.correct_answer_border_bg)
            if (mCurrentPostion != mQuestionList.size - 1) {
                btnSubmit.text = "Go to the next question"
            }

            else  btnSubmit.text = "Finish"

            setOptionClickable(false)
        }
        /////End of else block

        mSelectedOptionPostion = 0
    }



    private fun aswerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
        }

    }


    private fun goToTheResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUserName)
        intent.putExtra(Constants.SCORE, mScore)
        intent.putExtra(Constants.TIME, cTime.text.toString())
        startActivity(intent)
        finish()
    }




    private fun setOptionClickable(set: Boolean) {
        tvOptionOne.isClickable = set
        tvOptionTwo.isClickable = set
        tvOptionThree.isClickable = set
        tvOptionFour.isClickable = set
    }


    private fun initalize() {

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsQuantity = intent.getIntExtra(Constants.QUESTIONS_QUANTITY, 0)


        cTime = findViewById(R.id.c_time)
        tvScore = findViewById(R.id.tv_score)
        tvQuestionCount = findViewById(R.id.tv_answers_count)

        tvQuestion = findViewById(R.id.tv_question)
        ivQuestionImage = findViewById(R.id.iv_question_image)

        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)

        btnSubmit = findViewById(R.id.btnSubmit)
    }


}