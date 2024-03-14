package com.devletfarukalkan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1EditText = findViewById<EditText>(R.id.number1)
        val number2EditText = findViewById<EditText>(R.id.number2)
        val resultTextView = findViewById<TextView>(R.id.resultText)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton.setOnClickListener {
            performOperation(number1EditText, number2EditText, resultTextView, "+")
        }

        subtractButton.setOnClickListener {
            performOperation(number1EditText, number2EditText, resultTextView, "-")
        }

        multiplyButton.setOnClickListener {
            performOperation(number1EditText, number2EditText, resultTextView, "*")
        }

        divideButton.setOnClickListener {
            performOperation(number1EditText, number2EditText, resultTextView, "/")
        }
    }

    private fun performOperation(number1EditText: EditText, number2EditText: EditText, resultTextView: TextView, operation: String) {
        val number1 = number1EditText.text.toString().toDoubleOrNull()
        val number2 = number2EditText.text.toString().toDoubleOrNull()

        if (number1 == null || number2 == null) {
            resultTextView.text = "Please enter valid numbers."
            return
        }

        val result = when(operation) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> if (number2 != 0.0) number1 / number2 else "Cannot divide by zero."
            else -> "Invalid operation"
        }

        resultTextView.text = "Result: $result"

        number1EditText.text.clear()
        number2EditText.text.clear()
    }
}