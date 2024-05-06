package com.practicum.fragmentsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practicum.fragmentsexample.databinding.FragmentCitiesBinding

//наш класс должен наследоваться от класса Fragment
class CitiesFragment : Fragment() {

    private val cities = "New York\nLos Angeles\nLondon\nTokyo\nParis\nSan Francisco"

    // используем ViewBinding, мы можем использовать его так же как и в Activity
    private var _binding: FragmentCitiesBinding? = null

    // создаём неизменяемую переменную, к которой можно будет обращаться без ?. Мы должны не забыть инициализировать _binding, до того как использовать
    private val binding get() = _binding!!

    // в момент вызова onCreateView создаётся View для Fragment, поэтому именно в этот момент мы инициализируем binding и настраиваем View-элементы
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)

        binding.citiesTextView.text = cities
        return binding.root
    }
}