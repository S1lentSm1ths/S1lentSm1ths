package com.vsc.quizfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class FirstFragment :  Fragment( ) {

    private var questions : Int = 0
    private var trueCounter : Int = 0
    private var wrongCounter : Int = 0
    private lateinit var buttonSbm : Button
    private lateinit var buttonYes : Button
    private lateinit var buttonNo : Button

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
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        buttonYes = view.findViewById(R.id.radioBtnYes)
        buttonNo = view.findViewById(R.id.radioBtnNo)
        buttonSbm = view.findViewById(R.id.submitAnswer)

        buttonNo.setOnClickListener(){
            trueCounter++
            questions++
        }

        buttonYes.setOnClickListener(){
            wrongCounter++
            questions++
        }


        buttonSbm.setOnClickListener(){
            val action = FirstFragmentDirections.firstToSecond(questions, trueCounter, wrongCounter)
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}