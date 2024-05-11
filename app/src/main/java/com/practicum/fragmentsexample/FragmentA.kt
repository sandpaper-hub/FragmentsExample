package com.practicum.fragmentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.FragmentABinding

class FragmentA : Fragment(), SelectPage {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentTitle.text = (requireActivity() as TextStorage).getText().plus(" | Parent")
        val adapter = PagerAdapter(this)
        binding.pager.adapter = adapter
        binding.pager.setPageTransformer(ZoomOutPageTransformer())
    }

    override fun navigateTo(page: Int) {
        binding.pager.currentItem = page
    }
}