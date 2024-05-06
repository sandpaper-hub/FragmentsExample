package com.practicum.fragmentsexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practicum.fragmentsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            // в этот момент мы отображаем Fragment
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, CitiesFragment())
                .commit()
        }
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.replaceCountryFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CountriesFragment())
                .setReorderingAllowed(true)
                .commit()
        }

        binding.replaceBackstackCountryFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CountriesFragment())
                .addToBackStack("countries")
                .setReorderingAllowed(true)
                .commit()
        }
    }

}