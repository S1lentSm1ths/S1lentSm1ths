package com.vsc.quizfragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.Array.getInt

const val ARG_CORRECT_ANSWERS = "arg_correct_answers"
const val ARG_QUESTION = "arg_question"
const val ARG_WRONG_QUESTIONS = "arg_wrong_questions"

open class BaseClass : AppCompatActivity() {

    var trueCounter = 0
    var questions = 0
    var wrongCounter = 0

    lateinit var buttonYes: Button
    lateinit var buttonNo: Button


    fun getArgs() {
        val bundle = Bundle()

            trueCounter = bundle.getInt(ARG_CORRECT_ANSWERS)
            questions = bundle.getInt(ARG_QUESTION)
            wrongCounter = bundle.getInt(ARG_WRONG_QUESTIONS)

    }
}