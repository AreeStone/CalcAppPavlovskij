package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val result = intent.getDoubleExtra("result", 0.0)
        textViewResult.text = "Результат: $result"

        // Настройка кнопки "Назад"
        val buttonBack: Button = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish() // Закрывает текущую активность и возвращает на предыдущую
        }
    }
}
