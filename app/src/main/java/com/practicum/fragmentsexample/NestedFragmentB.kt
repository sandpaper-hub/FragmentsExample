package com.practicum.fragmentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.FragmentBNestedBinding

// Второй вложенный фрагмент
class NestedFragmentB : Fragment() {

    private var _binding: FragmentBNestedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBNestedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentText2.text = (requireActivity() as TextStorage).getText().plus(" | B")
        binding.button.setOnClickListener {
            (parentFragment as? SelectPage)?.navigateTo(0)
        }
    }
}