package com.carvalho.astromancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carvalho.astromancy.databinding.ActivityHoroscopeBinding
import com.carvalho.astromancy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.btnHoroscope?.setOnClickListener(){
            val intent = Intent(this, HoroscopeActivity::class.java)
            startActivity(intent)
        }
    }


}