package com.vsc.quizfragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : BaseClass(), Communicator, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var buttonStart: Button
    private lateinit var intoGame: IntoGame
    private lateinit var secondFragment: SecondFragment
    private lateinit var endScreen: EndScreen
    private lateinit var thirdFragment: ThirdFragment
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var bottomnav : BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var toggle: ActionBarDrawerToggle
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intoGame = IntoGame()
        navigationView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        bottomnav = findViewById(R.id.bottom_nav)
        navController = findNavController(R.id.nav_host_fragment)

        bottomnav.setupWithNavController(navController)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close)

        navigationView.setNavigationItemSelectedListener(this)

        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun countQuestions(questions: Int, trueCounter: Int, wrongCounter: Int) {
        val bundle = Bundle()
        bundle.putInt(ARG_CORRECT_ANSWERS, trueCounter)
        bundle.putInt(ARG_QUESTION, questions)
        bundle.putInt(ARG_WRONG_QUESTIONS, wrongCounter)

        secondFragment = SecondFragment()
        thirdFragment = ThirdFragment()

        secondFragment.arguments = bundle
        thirdFragment.arguments = bundle
    }

    override fun findNavController(): NavController {
        TODO("Not yet implemented")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.home) {
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, intoGame)
                .addToBackStack("return").commit()
        }

        if (item.itemId == R.id.myProfile) {
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, MyProfileFragment()).commit()
        }

        if (item.itemId == R.id.history){
            fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, MyHistory()).commit()
        }

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.item_settings){
            Toast.makeText(this, "Settings opened!", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.item_profile){
            Toast.makeText(this, "Your profile:", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.item_your_level){
            Toast.makeText(this, "Your level statistic", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.app_settings){
            Toast.makeText(this, "App settings opened!", Toast.LENGTH_LONG).show()
        }
        if (item.itemId == R.id.arrow_back){
            Toast.makeText(this, "You have been returned", Toast.LENGTH_LONG).show()
        }
        return true
    }

    private fun bottomNav(){

    }

}