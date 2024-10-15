package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)

        buttonAdd.setOnClickListener { calculate("+") }
        buttonSubtract.setOnClickListener { calculate("-") }
        buttonMultiply.setOnClickListener { calculate("*") }
        buttonDivide.setOnClickListener { calculate("/") }
    }

    private fun calculate(operation: String) {
        val number1 = editTextNumber1.text.toString().toDoubleOrNull()
        val number2 = editTextNumber2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                "/" -> if (number2 != 0.0) number1 / number2 else Double.NaN
                else -> 0.0
            }

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}
