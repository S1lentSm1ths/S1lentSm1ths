package com.vsc.quizfragments

import androidx.navigation.NavController

interface Communicator {
    fun countQuestions(questions : Int, trueCounter : Int, wrongCounter : Int)
    abstract fun findNavController(): NavController
}