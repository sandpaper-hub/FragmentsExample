package com.practicum.fragmentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.FragmentANestedBinding

class NestedFragmentA : Fragment() {
    private lateinit var binding: FragmentANestedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentANestedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            // Тут транзакция реализована через extension-функцию, а не через цепочку из методов
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_child_container, NestedFragmentB())
                .commit()
        }
    }
}
