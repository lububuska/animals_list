package com.example.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.animals.R

class SecondDetailFragment : Fragment() {

    companion object {
        fun newInstance(text: String): SecondDetailFragment {
            val fragment = SecondDetailFragment()
            fragment.arguments = Bundle().apply {
                putString("data", text)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_detail, container, false)
        val tv = view.findViewById<TextView>(R.id.secondDetail)
        tv.text = arguments?.getString("data") ?: "Нет данных"
        return view
    }
}
