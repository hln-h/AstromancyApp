package com.carvalho.astromancy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carvalho.astromancy.databinding.TarotActivityBinding
import com.carvalho.astromancy.model_tarotapi.ResponseRootModel
import com.carvalho.astromancy.model_tarotapi.TarotRequestModel
import com.carvalho.astromancy.model_tarotapi.TarotService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TarotActivity: AppCompatActivity() {

    private var binding: TarotActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TarotActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.askBtn?.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val response = getTarotAnswer()
                withContext(Dispatchers.Main) {
                    binding?.test?.text="${response}"
                }
                }
            }
        }



    private val BASEURL = "https://divineapi.com/api/1.0/"
    private val retrofit = createRetrofit()
    private val service: TarotService = retrofit.create(TarotService::class.java)

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun getTarotAnswer(): ResponseRootModel? {
        val request = TarotRequestModel("8bf1211fd4b7b94528899de0a43b9fb3")
        val response = service.getDailyTarot(request).execute()
        return if (response.isSuccessful) {
            response.body()
            null
        } else {
            null
        }
    }
}

//https://divineapi.com/api/1.0/get_yes_or_no_tarot.php?api_key=8bf1211fd4b7b94528899de0a43b9fb3