package com.carvalho.astromancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carvalho.astromancy.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        loadButtons()

    }




    private fun loadButtons() {
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
        transaction.commit()
    }


    fun loadHoroscopeToday(starsign: String, day: String) {
        val transaction = supportFragmentManager.beginTransaction()
        val horoscopeToday = OverviewFragment(starsign, day)
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, horoscopeToday, "horoscopeToday")
        transaction.commit()
    }

    fun loadTarotActivity() {
        val intent = Intent(this, TarotActivity::class.java)
        startActivity(intent)
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


}
