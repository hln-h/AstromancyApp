package com.carvalho.astromancy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.databinding.FragmentHomeButtonsBinding

class ButtonFragment : Fragment(R.layout.fragment_home_buttons) {
     lateinit var binding: FragmentHomeButtonsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeButtonsBinding.bind(view)
        binding?.btnHoroscope?.setOnClickListener() {
            (activity as MainActivity).loadHoroscopeMain()
        }

        binding?.btnTarot?.setOnClickListener {
            (activity as MainActivity).loadTarotActivity()

        }
    }
    }

