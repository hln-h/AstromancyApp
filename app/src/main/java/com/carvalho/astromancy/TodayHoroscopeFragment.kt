package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentTodayHoroscopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodayHoroscopeFragment(val starsign: String) : Fragment(R.layout.fragment_today_horoscope) {

    private lateinit var binding: FragmentTodayHoroscopeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTodayHoroscopeBinding.bind(view)

        fetchData(starsign)
    }

    private fun fetchData(starsign: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val repo = HoroscopeRepository()
            val response = repo.getTodaysHoroscope(starsign)
            withContext(Dispatchers.Main) {
                binding?.tvTodaysHoroscope?.text = "${response?.description}"
                binding?.tvDate?.text = "Today"
                binding?.tvDetails?.text =
                    "Compatibility: ${response?.compatibility}; Mood: ${response?.mood}; Color: ${response?.color}; Lucky Number: ${response?.luckyNumber}, Lucky Time: ${response?.luckyTime}"
            }
        }
    }
}