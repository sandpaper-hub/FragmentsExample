package com.practicum.fragmentsexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.toFragmentAButton.setOnClickListener {
            val fragment = FragmentA().apply {
                arguments = bundleOf("SOMETEXT" to binding.toFragmentAEditText.text.toString())
            }

            createFragment(fragment)
        }

        binding.toFragmentBButton.setOnClickListener {
            val fragment = FragmentB().apply {
                arguments = bundleOf("SOMETEXT" to binding.toBFragmentEditText.text.toString())
            }

            createFragment(fragment)
        }
    }

    private fun createFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .setReorderingAllowed(true)
            .commit()
    }
}