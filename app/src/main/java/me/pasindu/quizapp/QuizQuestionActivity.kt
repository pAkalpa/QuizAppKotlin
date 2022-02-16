package me.pasindu.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.pasindu.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)

        val questionsList = Constants.getQuestions()
        Log.i("QuestionsList size is", "${questionsList.size}")
    }
}