package com.example.animals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animals.SecondDetailFragment
import com.example.animals.SecondListFragment

class SecondActivity : AppCompatActivity(), SecondListFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportFragmentManager.beginTransaction()
            .replace(R.id.secondContainer, SecondListFragment())
            .commit()
    }

    override fun onItemChosen(value: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.secondContainer, SecondDetailFragment.newInstance(value))
            .addToBackStack(null)
            .commit()
    }
}
