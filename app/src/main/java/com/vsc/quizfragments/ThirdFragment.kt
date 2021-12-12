package com.vsc.quizfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import java.util.*


class ThirdFragment : Fragment() {

    private val args : ThirdFragmentArgs by navArgs()
    private lateinit var buttonSbm : Button
    private lateinit var answerInput : EditText
    private lateinit var textTest : TextView
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
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        buttonSbm = view.findViewById(R.id.buttonSbmAnswer)
        answerInput = view.findViewById(R.id.input_answer)

        questions = args.questions
        trueCounter = args.trueCounter
        wrongCounter = args.wrongCounter

        val getAnswer = answerInput.text.toString().lowercase()

        if (getAnswer.contains("yes")){
            trueCounter++
            questions++
        }
        else {
            wrongCounter++
            questions++
        }

        buttonSbm.setOnClickListener(){
            val action = ThirdFragmentDirections.thirdFaragmentToEndScreen(questions, trueCounter, wrongCounter)
            findNavController().navigate(action)
        }

        return view
    }
}