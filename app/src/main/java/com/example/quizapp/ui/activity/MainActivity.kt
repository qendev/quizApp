package com.example.quizapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.constants.Constants
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonStart.setOnClickListener {
            val editTextName = binding.editTextName
            if (editTextName.text?.isEmpty() == true){
                Toast.makeText(this,"Please Enter Your Name.",Toast.LENGTH_LONG).show()

            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                //pass additional data
                intent.putExtra(Constants.USER_NAME,editTextName.text.toString())
                startActivity(intent)
                finish()


            }

        }
    }
}