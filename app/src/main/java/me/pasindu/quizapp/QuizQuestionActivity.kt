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

        for (i in questionsList) {
            Log.e("Question", i.question)
        }
        var currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]
        binding.ivImage.setImageResource(question.image)
        binding.progressBar.progress = currentPosition
        binding.progress.text = "${currentPosition}/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour


    }
}