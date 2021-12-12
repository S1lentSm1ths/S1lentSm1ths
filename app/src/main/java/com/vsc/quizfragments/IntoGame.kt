package com.vsc.quizfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation

class IntoGame : Fragment() {

    private lateinit var buttonStartTheGame: Button

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
        val view = inflater.inflate(R.layout.fragment_into_game, container, false)
        buttonStartTheGame = view.findViewById(R.id.btnStartGame)
        buttonStartTheGame.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.intoTheGameToFirstFragment)
        }
        return view
    }
}