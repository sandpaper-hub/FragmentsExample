package com.practicum.fragmentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.FragmentAuthorizationBinding

class FragmentAuthorization : Fragment() {
    private lateinit var binding: FragmentAuthorizationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, FragmentLogin())
                .setReorderingAllowed(true)
                .commit()
        }
        binding.registrationButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, FragmentRegistration())
                .addToBackStack("registration")
                .setReorderingAllowed(true)
                .commit()
        }
        return binding.root
    }
}