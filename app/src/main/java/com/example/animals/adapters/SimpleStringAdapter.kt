package com.example.animals.adapters

import android.content.Context
import android.widget.ArrayAdapter

class SimpleStringAdapter(
    context: Context,
    data: List<String>
) : ArrayAdapter<String>(
    context,
    android.R.layout.simple_list_item_1,
    data
)
