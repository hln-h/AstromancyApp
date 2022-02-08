package com.carvalho.astromancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carvalho.astromancy.databinding.ActivityMainBinding

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


    fun loadHoroscopeToday(starsign:String) {
        val transaction = supportFragmentManager.beginTransaction()
        val horoscopeMain = TodayHoroscopeFragment(starsign)
        val mainLayoutId = R.id.fragment_container
        transaction.add(mainLayoutId, horoscopeMain, "horoscopeToday")
        transaction.commit()
    }


}