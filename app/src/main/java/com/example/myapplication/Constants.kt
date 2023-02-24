package com.example.myapplication

object Constants {

    const val USER_NAME: String = "user_name"
    const val SCORE: String = "score"
    const val QUESTIONS_QUANTITY: String = "questions_quantity"
    const val TIME: String = "time"


    fun getQuestions(amount:Int): ArrayList<Question> {
        val questionsList: ArrayList<Question> = ArrayList()
        val finalQuestionsList: ArrayList<Question> = ArrayList()







        // 1
        val que1 = Question(
            1, "What color is this?",
            R.drawable.ic_brown_color,
            "Brown", "Green",
            "Red", "Yellow", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What color is this?",
            R.drawable.ic_pink_color,
            "Brown", "Green",
            "Pink", "Yellow", 3
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What color is this?",
            R.drawable.ic_pink_color,
            "Pink", "Green",
            "Brown", "Yellow", 1
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What color is this?",
            R.drawable.ic_pink_color,
            "Green", "Brown",
            "Pink", "Yellow", 3
        )

        questionsList.add(que10)

        questionsList.shuffle()
          for(i in 0..amount-1){
              finalQuestionsList.add(questionsList.elementAt(i))
          }


        return finalQuestionsList
    }
    // END
    }
