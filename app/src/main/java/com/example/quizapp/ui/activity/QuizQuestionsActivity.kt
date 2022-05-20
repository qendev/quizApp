package com.example.quizapp.ui.activity

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.constants.Constants
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding
import com.example.quizapp.model.Question

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    //to help us retrieve the data sent from the mainActivity
    private var mUserName:String? = null
    //inorder to store how many answers we have correct
    private var mCorrectAnswers:Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //to get the value sent from the mainActivity
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestion()


        //adding onclick listeners to all the options we need to be clickable
        binding.textViewOptionOne.setOnClickListener(this)
        binding.textViewOptionTwo.setOnClickListener(this)
        binding.textViewOptionThree.setOnClickListener(this)
        binding.textViewOptionFour.setOnClickListener(this)
        binding.buttonSubmit.setOnClickListener(this)




        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionView()
        //set the textView of the question and set the progress for the progressBar
        //the current individual question we are currently at
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        //set up the flag imageView
        val imageViewFlag = binding.imageViewFlag
        imageViewFlag.setImageResource(question.image)
        //set the progressBar to the current position
        val myProgressBar = binding.progressBar
        myProgressBar.progress = mCurrentPosition
        val textViewProgress = binding.textViewProgress
        textViewProgress.text = "$mCurrentPosition / ${myProgressBar.max}"
        //set up the question
        val textViewQuestion = binding.textViewQuestion
        textViewQuestion.text = question.question

        //set up the textViews for the options
        val textViewOptionOne = binding.textViewOptionOne
        textViewOptionOne.text = question.optionOne

        val textViewOptionTwo = binding.textViewOptionTwo
        textViewOptionTwo.text = question.optionTwo

        val textViewOptionThree = binding.textViewOptionThree
        textViewOptionThree.text = question.optionThree

        val textViewOptionFour = binding.textViewOptionFour
        textViewOptionFour.text = question.optionFour

        //at the last enty of the question do this.
        if (mCurrentPosition == mQuestionList!!.size) {
            val buttonSubmit = binding.buttonSubmit
            buttonSubmit.text = "FINISH"
        } else {
            val buttonSubmit = binding.buttonSubmit
            buttonSubmit.text = "SUBMIT"


        }
    }

    //Default view of the answer Options to the question
    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        val textViewOptionOne = binding.textViewOptionOne
        textViewOptionOne.let {
            options.add(0, it)
        }

        val textViewOptionTwo = binding.textViewOptionTwo
        textViewOptionTwo.let {
            options.add(1, it)

        }
        val textViewOptionThree = binding.textViewOptionThree
        textViewOptionThree.let {
            options.add(2, it)

        }
        val textViewOptionFour = binding.textViewOptionFour
        textViewOptionFour.let {
            options.add(3, it)

        }

        for (option in options) {
            //setting the text color on the options button
            option.setTextColor(Color.parseColor("#989898"))
            //setting the typeface to be default so to be able to change it once its selected
            option.typeface = Typeface.DEFAULT
            //setting the background for the button
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        //to make the selected option bold
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        //to set the background for the selected option
        textView.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )

    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textViewOptionOne -> {
                selectedOptionView(binding.textViewOptionOne, 1)

            }

            R.id.textViewOptionTwo -> {
                selectedOptionView(binding.textViewOptionTwo, 2)

            }

            R.id.textViewOptionThree -> {
                selectedOptionView(binding.textViewOptionThree, 3)

            }

            R.id.textViewOptionFour -> {
                selectedOptionView(binding.textViewOptionFour, 4)

            }

            R.id.buttonSubmit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            //to prevent the user from bein able to go back to the questions screen
                            finish()

                        }
                    }



                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){
                        binding.buttonSubmit.text = "FINISH"
                    }
                    else{
                        binding.buttonSubmit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }

            }


        }


    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                binding.textViewOptionOne.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }

            2->{
                binding.textViewOptionTwo.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }

            3->{
                binding.textViewOptionThree.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }

            4->{
                binding.textViewOptionFour.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }

    }


}