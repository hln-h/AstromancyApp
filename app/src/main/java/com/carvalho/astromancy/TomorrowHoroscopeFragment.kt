package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentTodayHoroscopeBinding
import com.carvalho.astromancy.databinding.FragmentTomorrowHoroscopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TomorrowHoroscopeFragment (val starsign: String, var day: String) : Fragment(R.layout.fragment_tomorrow_horoscope){

    private lateinit var binding: FragmentTomorrowHoroscopeBinding

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = FragmentTomorrowHoroscopeBinding.bind(view)
            day = "tomorrow"
            fetchData(starsign, day)

            binding?.btnToday?.setOnClickListener() {
                var starsign = starsign
                (activity as MainActivity).loadHoroscopeToday(starsign, day)}

            binding?.btnYesterday?.setOnClickListener() {
                var starsign = starsign
                (activity as MainActivity).loadHoroscopeYesterday(starsign, day)}
        }

        private fun fetchData(starsign: String, day:String) {
            CoroutineScope(Dispatchers.IO).launch {
                val repo = HoroscopeRepository()
                val response = repo.getTodaysHoroscope(starsign, day)
                withContext(Dispatchers.Main) {
                    binding?.tvTomorrowsHoroscope?.text = "${response?.description}"
                    binding?.tvDate?.text = "${day}"
                    binding?.tvTomorrowDetails?.text =
                        "Compatibility: ${response?.compatibility}; Mood: ${response?.mood}; Color: ${response?.color}; Lucky Number: ${response?.luckyNumber}, Lucky Time: ${response?.luckyTime}"
                }
            }
        }
    }
