package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentHoroscopeMainBinding


class HoroscopeMainFragment:Fragment(R.layout.fragment_horoscope_main)  {

    lateinit var binding: FragmentHoroscopeMainBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHoroscopeMainBinding.bind(view)

        binding.goHomeBtn.setOnClickListener {
            (activity as MainActivity).loadButtons()
        }

        binding?.btnAquarius?.setOnClickListener() {
            var starsign = "Aquarius"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnAries?.setOnClickListener() {
            var starsign = "Aries"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnCancer?.setOnClickListener() {
            var starsign = "Cancer"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnCapricorn?.setOnClickListener() {
            var starsign = "Capricorn"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnGemini?.setOnClickListener() {
            var starsign = "Gemini"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnLeo?.setOnClickListener() {
            var starsign = "Leo"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }

        binding?.btnLibra?.setOnClickListener() {
            var starsign = "Libra"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnPisces?.setOnClickListener() {
            var starsign = "Pisces"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnSagittarius?.setOnClickListener() {
            var starsign = "Sagittarius"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnScorpio?.setOnClickListener() {
            var starsign = "Scorpio"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
        binding?.btnTaurus?.setOnClickListener() {
            var starsign = "Taurus"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }

        binding?.btnVirgo?.setOnClickListener() {
            var starsign = "Virgo"
            var day = "today"
            (activity as MainActivity).loadHoroscopeToday(starsign, day)
        }
    }}