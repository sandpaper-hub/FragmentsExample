package com.practicum.fragmentsexample


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class NumbersViewPagerAdapter(framentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(framentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return SomeFragment.newInstance(position + 1)
    }
}