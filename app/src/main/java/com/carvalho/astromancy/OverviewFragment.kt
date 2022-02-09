package com.carvalho.astromancy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.carvalho.astromancy.databinding.FragmentOverviewBinding

class OverviewFragment (val starsign: String, var day: String): Fragment(R.layout.fragment_overview) {
private lateinit var binding: FragmentOverviewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOverviewBinding.bind(view)

        val pagerAdapter = object: FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                val fragment = TodayHoroscopeFragment(starsign, getDayString(position))
                return fragment
            }
        }

        binding.pager.adapter = pagerAdapter
        binding.pager.post { binding.pager.setCurrentItem(1,true) }
    }

    private fun getDayString(pos: Int) = when(pos) {
        2 -> "Tomorrow"
        1 -> "Today"
        else -> "Yesterday"
    }
}