package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentTodayHoroscopeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodayHoroscopeFragment(val starsign: String, val day: String) :
    Fragment(R.layout.fragment_today_horoscope) {

    private lateinit var binding: FragmentTodayHoroscopeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTodayHoroscopeBinding.bind(view)

        binding.progressBar.visibility = View.VISIBLE
        binding.loadingMessage.visibility = View.VISIBLE

        fetchData(starsign, day)


    }




    private fun fetchData(starsign: String, day: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val repo = HoroscopeRepository()
            val response = repo.getTodaysHoroscope(starsign, day)
            withContext(Dispatchers.Main) {
                binding.tvStarsign.text = "${starsign}"
                binding.tvTodaysHoroscope?.text = "${response?.description}"
                binding.tvDate.text = "${day}"
                binding.tvCompatibility?.text = "${response?.compatibility}"
                binding.tvMood.text = "${response?.mood}"
                binding.tvColor.text = "${response?.color}"
                binding.tvNumber.text = "${response?.luckyNumber}"
                binding.tvTime.text = "${response?.luckyTime}"

                binding.ivStarsign.setImageResource(
                    when (starsign) {
                        "Aries" -> R.drawable.aries
                        "Aquarius" -> R.drawable.aquarius
                        "Cancer" -> R.drawable.cancer
                        "Gemini" -> R.drawable.gemini
                        "Leo" -> R.drawable.leo
                        "Libra" -> R.drawable.libra
                        "Pisces" -> R.drawable.pisces
                        "Sagittarius" -> R.drawable.saggitarius
                        "Scorpio" -> R.drawable.scorpio
                        "Taurus" -> R.drawable.taurus
                        "Virgo" -> R.drawable.virgo
                        else -> R.drawable.capricorn
                    }
                )
            }

            binding.progressBar.visibility = View.GONE
            binding.loadingMessage.visibility = View.GONE

        }


    }

}