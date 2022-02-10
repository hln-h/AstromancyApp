package com.carvalho.astromancy.tarotFrags

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.MainActivity
import com.carvalho.astromancy.R
import com.carvalho.astromancy.databinding.QuestionFragBinding

class TarotQuestion:Fragment(R.layout.question_frag) {
    lateinit var binding:QuestionFragBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = QuestionFragBinding.bind(view)

        binding.homeBtn.setOnClickListener {
            (activity as MainActivity).loadButtons()
       }

        binding.askBtn.setOnClickListener {
            (activity as MainActivity).getTarotAnswer()
        }

    }

}