package com.example.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.animals.R

class FragmentB : Fragment() {

    private var text: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        text = view.findViewById(R.id.selectedAnimal)
        return view
    }

    fun updateAnimal(name: String) {
        text?.text = "Вы выбрали: $name"
    }
}
