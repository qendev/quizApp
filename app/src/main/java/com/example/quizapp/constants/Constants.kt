package com.example.quizapp.constants

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"



    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What Country does this flag belong to?",
             R.drawable.ic_flag_of_argentina,
             "Argentina","Uruguay","Chile","Venezuela",
             1
        )
        questionList.add(que1)

        val que2 = Question(
            2,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Armenia","Australia","New Zealand","Austria",
            2
        )
        questionList.add(que2)

        val que3 = Question(
            3,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Germany","Poland","Denmark","Belgium",
            4
        )
        questionList.add(que3)

        val que4 = Question(
            4,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Colombia","Brazil","Chile","Belgium",
            2
        )
        questionList.add(que4)

        val que5 = Question(
            5,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark","Norway","Ice Land","Sweden",
            1
        )
        questionList.add(que5)

        val que6 = Question(
            6,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Solomon Islands","Hawaii","Bahrain","Fiji",
            4
        )
        questionList.add(que6)

        val que7 = Question(
            7,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany","Belgium","Russia","Ukrain",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Pakistan","Palestine","Philippines","India",
            4
        )
        questionList.add(que8)

        val que9 = Question(
            9,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait","Pakistan","Palestine","Iraq",
            1
        )
        questionList.add(que9)

        val que10 = Question(
            10,"What Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia","New Zealand","Austria","Sweden",
            2
        )
        questionList.add(que10)

        return questionList
    }
}