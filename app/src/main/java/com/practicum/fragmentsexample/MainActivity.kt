package com.practicum.fragmentsexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), TextStorage {
    private var someText = "Bla, bla, bla"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .commit()
        }
    }

    override fun getText(): String {
        return someText
    }
}