package com.example.animals

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    interface Callback {
        fun onAnimalSelected(name: String)
    }

    private var callback: Callback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Callback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val list = view.findViewById<ListView>(R.id.listAnimals)
        val animals = listOf("Кошка", "Собака", "Лев", "Панда", "Енот")

        val adapter = AnimalAdapter(requireContext(), animals)
        list.adapter = adapter

        list.setOnItemClickListener { _, _, pos, _ ->
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
