package com.example.animals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.animals.adapters.SimpleStringAdapter

class SecondListFragment : Fragment() {

    interface Callback {
        fun onItemChosen(value: String)
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
        val view = inflater.inflate(R.layout.fragment_second_list, container, false)

        val list = view.findViewById<ListView>(R.id.secondList)
        val data = listOf("Красный", "Зелёный", "Синий", "Белый")

        list.adapter = SimpleStringAdapter(requireContext(), data)

        list.setOnItemClickListener { _, _, pos, _ ->
            callback?.onItemChosen(data[pos])
        }

        return view
    }
}
