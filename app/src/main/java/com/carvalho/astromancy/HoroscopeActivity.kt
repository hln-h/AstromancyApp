package com.carvalho.astromancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.carvalho.astromancy.databinding.ActivityHoroscopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HoroscopeActivity : AppCompatActivity() {
    private var binding: ActivityHoroscopeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnShowHoroscope?.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val response = getTodaysHoroscope(binding?.etStarsign?.getText().toString())
                withContext(Dispatchers.Main){
                    binding?.tvTodaysHoroscope?.text = "${response?.description}"
                    binding?.tvDate?.text = "Today"
                    binding?.tvDetails?.text = "Compatibility: ${response?.compatibility}; Mood: ${response?.mood}; Color: ${response?.color}; Lucky Number: ${response?.luckyNumber}, Lucky Time: ${response?.luckyTime}"
                }
            }

        }
    }

    private val BASEURL = "https://aztro.sameerkumar.website/"
    private val retrofit = createRetrofit()
    private val service: HoroscopeService = retrofit.create(HoroscopeService::class.java)

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun getTodaysHoroscope(etStarSign: String): HoroscopeResponseModel? {
        val response = service.getTodayHoroscope("${etStarSign}", "today").execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            Log.e("HTTP ERROR TAG", "${response.errorBody()}")
            null
        }

    }
}