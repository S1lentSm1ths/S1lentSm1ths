package com.vsc.quizfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class EndScreen : Fragment() {

    private val args : EndScreenArgs by navArgs()
    private var questions : Int = 0
    private var trueCounter : Int = 0
    private var wrongCounter : Int = 0
    private lateinit var messageText : TextView
    private lateinit var questionsAndAnswers : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_end_screen, container, false)

        questions = args.questions
        trueCounter = args.trueCounter
        wrongCounter = args.wrongCounter

        messageText = view.findViewById(R.id.messageText)
        questionsAndAnswers = view.findViewById(R.id.questions_And_Answers)

        if (wrongCounter < 3){
            messageText.text = "Good, you can more!"
        }
        else if (wrongCounter >= 3){
            messageText.text = "Excellent!"
        }

        questionsAndAnswers.text = "You have $trueCounter true answers from $questions questions!"

        return view
    }

}