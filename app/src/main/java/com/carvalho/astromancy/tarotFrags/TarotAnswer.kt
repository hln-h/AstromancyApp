package com.carvalho.astromancy.tarotFrags

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.HoroscopeRepository
import com.carvalho.astromancy.R
import com.carvalho.astromancy.TarotRepository
import com.carvalho.astromancy.databinding.AnswerFragBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TarotAnswer:Fragment(R.layout.answer_frag) {

    lateinit var binding:AnswerFragBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AnswerFragBinding.bind(view)


            CoroutineScope(Dispatchers.IO).launch {
                val repo = TarotRepository()
                val response = repo.getTarotAnswer()
                withContext(Dispatchers.Main) {
                    binding.tarotAnswer.text = "${response}"
                }
            }
        }

    }

