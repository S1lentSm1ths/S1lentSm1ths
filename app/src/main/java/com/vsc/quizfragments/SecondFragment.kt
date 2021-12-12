package com.vsc.quizfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.ConfigurationCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val args : SecondFragmentArgs by navArgs()
    private lateinit var buttonSbm : Button
    private lateinit var inputAnswer : EditText
    private lateinit var answerText : String
    private val answerYes : String = "yes"
    private var questions : Int = 0
    private var trueCounter : Int = 0
    private var wrongCounter : Int = 0

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
       val view = inflater.inflate(R.layout.fragment_second, container, false)

        inputAnswer = view.findViewById(R.id.input_answer)
        answerText = inputAnswer.text.toString()

        questions = args.questions
        trueCounter = args.trueCounter
        wrongCounter = args.wrongCounter

        if (answerText == answerYes){
            trueCounter++
            questions++
        }
        else {
            wrongCounter++
            questions++
        }

        buttonSbm = view.findViewById(R.id.submitBtn)

        buttonSbm.setOnClickListener(){
            val action = SecondFragmentDirections.secondFragmentToThird(questions, trueCounter, wrongCounter)
            findNavController().navigate(action)
        }
        return view
    }
}