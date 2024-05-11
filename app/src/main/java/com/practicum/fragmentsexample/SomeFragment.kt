package com.practicum.fragmentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.SomeFragmentBinding

class SomeFragment : Fragment() {
    companion object {
        private const val NUMBER = "NUMBER"

        fun newInstance(number: Int) = SomeFragment().apply {
            arguments = Bundle().apply {
                putInt(NUMBER, number)
            }
        }
    }

    private lateinit var binding: SomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.numberTextView.text = requireArguments().getInt(NUMBER).toString()
    }
}