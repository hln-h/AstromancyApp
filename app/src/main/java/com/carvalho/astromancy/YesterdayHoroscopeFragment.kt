package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentTomorrowHoroscopeBinding
import com.carvalho.astromancy.databinding.FragmentYesterdayHoroscopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class YesterdayHoroscopeFragment(val starsign: String, var day: String) :
    Fragment(R.layout.fragment_yesterday_horoscope) {

    private lateinit var binding: FragmentYesterdayHoroscopeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentYesterdayHoroscopeBinding.bind(view)
        day = "yesterday"
        fetchData(starsign, day)

        binding?.btnTomorrow?.setOnClickListener() {
            var starsign = starsign
            (activity as MainActivity).loadHoroscopeTomorrow(starsign, day)}

        binding?.btnToday?.setOnClickListener() {
            var starsign = starsign
            (activity as MainActivity).loadHoroscopeToday(starsign, day)}
    }

    private fun fetchData(starsign: String, day: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val repo = HoroscopeRepository()
            val response = repo.getTodaysHoroscope(starsign, day)
            withContext(Dispatchers.Main) {
                binding?.tvYesterdaysHoroscope?.text = "${response?.description}"
                binding?.tvDate?.text = "${day}"
                binding?.tvYesterdaysDetails?.text =
                    "Compatibility: ${response?.compatibility}; Mood: ${response?.mood}; Color: ${response?.color}; Lucky Number: ${response?.luckyNumber}, Lucky Time: ${response?.luckyTime}"
            }
        }
    }
}
