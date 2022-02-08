package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentHoroscopeMainBinding

class HoroscopeMainFragment:Fragment(R.layout.fragment_horoscope_main) {

    lateinit var binding: FragmentHoroscopeMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHoroscopeMainBinding.bind(view)
        binding?.btnShowHoroscope?.setOnClickListener() {
            var starsign = binding?.etStarsign?.getText().toString()
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)

    }
}}