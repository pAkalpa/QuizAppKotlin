package me.pasindu.quizapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import me.pasindu.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuizQuestionBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {

        mCurrentPosition = 1
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        binding.ivImage.setImageResource(question.image)
        binding.progressBar.progress = mCurrentPosition
        binding.progress.text = "${mCurrentPosition}/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size) {
            binding.btnSubmit.text = getString(R.string.FINISH)
        } else {
            binding.btnSubmit.text = getString(R.string.SUBMIT)
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        binding.tvOptionOne.let {
            options.add(0, it)
        }

        binding.tvOptionTwo.let {
            options.add(1, it)
        }

        binding.tvOptionThree.let {
            options.add(2, it)
        }

        binding.tvOptionFour.let {
            options.add(3, it)
        }

        for (option in options) {
//            option.setTextColor(Color.parseColor("#7A8089"))
//            option.setTextColor(ContextCompat.getColor(this,R.color.red))
            option.setTextColor(ContextCompat.getColor(this, R.color.cardTextS))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(ContextCompat.getColor(this, R.color.cardTextW))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.tvOptionOne.id -> selectedOptionView(binding.tvOptionOne, 1)
            binding.tvOptionTwo.id -> selectedOptionView(binding.tvOptionTwo, 2)
            binding.tvOptionThree.id -> selectedOptionView(binding.tvOptionThree, 3)
            binding.tvOptionFour.id -> selectedOptionView(binding.tvOptionFour, 4)
            binding.btnSubmit.id -> {
//                TODO "Implement btn submit"
            }
        }
    }
}