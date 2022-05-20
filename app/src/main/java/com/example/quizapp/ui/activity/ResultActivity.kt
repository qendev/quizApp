package com.example.quizapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.R
import com.example.quizapp.constants.Constants
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding:ActivityResultBinding

    private var mUserName:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val textViewName = binding.tvName
        val textViewScore = binding.tvScore
        val buttonFinish = binding.btnFinish

        //set the value sent from the intent

        textViewName.text = intent.getStringExtra(Constants.USER_NAME)

        //get the values of total questions and correct answers from the intents  and assign them to hte respective textView
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        textViewScore.text = "Your score is $correctAnswers out of $totalQuestions"

        buttonFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }



    }
}