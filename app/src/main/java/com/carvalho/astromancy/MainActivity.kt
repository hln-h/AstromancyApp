package com.carvalho.astromancy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carvalho.astromancy.databinding.ActivityMainBinding
import com.carvalho.astromancy.tarotFrags.TarotAnswer
import com.carvalho.astromancy.tarotFrags.TarotQuestion


class MainActivity : AppCompatActivity() {
//    private var binding: ActivityMainBinding? = null

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        loadButtons()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


     fun loadButtons() {
        val transaction = supportFragmentManager.beginTransaction()
        val horoscopeMain = ButtonFragment()
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, horoscopeMain, "buttonsMain")
        transaction.commit()
    }

    fun loadHoroscopeMain() {
        val transaction = supportFragmentManager.beginTransaction()
        val horoscopeMain = HoroscopeMainFragment()
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, horoscopeMain, "horoscopeMain")
        transaction.addToBackStack("horoscopeMain")
        transaction.commit()
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    fun loadHoroscopeToday(starsign: String, day: String) {
        val transaction = supportFragmentManager.beginTransaction()
        val horoscopeToday = OverviewFragment(starsign, day)
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, horoscopeToday, "horoscopeToday")
        transaction.addToBackStack ("horoscopeToday")
        transaction.commit()
    }




    fun getTarotAnswer() {
        val transaction = supportFragmentManager.beginTransaction()
        val answer = TarotAnswer()
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, answer, "Tarot Answer")
        transaction.addToBackStack ("Tarot Answer")
        transaction.commit()
    }

    fun loadTarotActivity() {
        val transaction = supportFragmentManager.beginTransaction()
        val question = TarotQuestion()
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, question, "Tarot Question")
        transaction.addToBackStack ("Tarot Question")
        transaction.commit()
    }

//    fun loadHoroscopeTomorrow(starsign: String, day: String) {
//        val transaction = supportFragmentManager.beginTransaction()
//        val horoscopeTomorrow = TomorrowHoroscopeFragment(starsign, day)
//        val mainLayoutId = R.id.fragment_container
//        transaction.add(mainLayoutId, horoscopeTomorrow, "horoscopeTomorrow")
//        transaction.commit()
//    }
//
//    fun loadHoroscopeYesterday(starsign: String, day: String) {
//        val transaction = supportFragmentManager.beginTransaction()
//        val horoscopeYesterday = YesterdayHoroscopeFragment(starsign, day)
//        val mainLayoutId = R.id.fragment_container
//        transaction.add(mainLayoutId, horoscopeYesterday, "horoscopeYesterday")
//        transaction.commit()
//
//    }

//TEST
}