package com.example.animals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animals.FragmentA
import com.example.animals.FragmentB

class MainActivity : AppCompatActivity(), FragmentA.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Добавляем фрагменты в контейнеры (если они ещё не добавлены)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerA, FragmentA())
                .replace(R.id.containerB, FragmentB())
                .commit()
        }
    }

    override fun onAnimalSelected(name: String) {
        // Находим фрагмент по id и безопасно приводим к FragmentB
        val fragment = supportFragmentManager.findFragmentById(R.id.containerB)
        if (fragment is FragmentB) {
            fragment.updateAnimal(name)
        } else {
            // если в контейнере пока нет FragmentB — создаём его и передаём аргумент
            val newFrag = FragmentB().apply {
                // можно использовать аргументы, если захочешь (bundle)
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerB, newFrag)
                .commit()
            // после замены можно вызвать update через post (или через аргументы)
            supportFragmentManager.executePendingTransactions()
            (supportFragmentManager.findFragmentById(R.id.containerB) as? FragmentB)?.updateAnimal(name)
        }
    }
}
