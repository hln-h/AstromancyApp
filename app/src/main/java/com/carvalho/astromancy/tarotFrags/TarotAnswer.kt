package com.carvalho.astromancy.tarotFrags

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carvalho.astromancy.MainActivity
import com.carvalho.astromancy.R
import com.carvalho.astromancy.TarotRepository
import com.carvalho.astromancy.databinding.AnswerFragBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TarotAnswer:Fragment(R.layout.answer_frag) {

    lateinit var binding:AnswerFragBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AnswerFragBinding.bind(view)

        binding.goBackBtn.setOnClickListener {
            (activity as MainActivity).loadTarotActivity()
        }

        binding.homeBtn.setOnClickListener {
            (activity as MainActivity).loadButtons()
        }
            CoroutineScope(Dispatchers.IO).launch {
                val repo = TarotRepository()
                val response = repo.getTarotAnswer()
                withContext(Dispatchers.Main) {
                    binding.tarotYesNo.text = "${response?.data?.yesno}"
                    binding.tarotCardName.text ="${response?.data?.card}"
                    binding.tarotAnswer.text = "${response?.data?.result}"
                    Picasso.get().load("${response?.data?.cardImage}").into(binding.tarotImg)

                }
            }
        }
    }
