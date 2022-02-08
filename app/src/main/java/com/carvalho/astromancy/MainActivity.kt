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


        binding?.btnHoroscope?.setOnClickListener() {
            val intent = Intent(this, HoroscopeActivity::class.java)
            startActivity(intent)
        }

        binding?.btnCompatibility?.setOnClickListener {
            val intent = Intent(this, TarotActivity::class.java)
            startActivity(intent)
        }


    }
}


