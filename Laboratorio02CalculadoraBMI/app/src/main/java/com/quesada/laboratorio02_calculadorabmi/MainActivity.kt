package com.quesada.laboratorio02_calculadorabmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    //Elementos de UI
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var calculationTextView: TextView
    private lateinit var statusTextView: TextView

    //Data

    private var bmi: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setListeners()
    }

    private fun setListeners(){
        calculateButton.setOnClickListener {
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()
            if(weight.isNullOrEmpty() || height.isNullOrEmpty()){
                Toast.makeText(this,"Empty Text", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            bmi = weight.toFloat() / ((height.toFloat() * height.toFloat()) / 10000)
            calculationTextView.text = bmi.toString()
            result(bmi)
        }
    }

    private fun result(bmi: Float) {
        when {
            bmi <= 18.5 -> {
                statusTextView.text = "Underweight"
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
            }
            bmi in 18.5..24.99 -> {
                statusTextView.text = "Normal"
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
            }
            bmi in 25.0..29.99 -> {
                statusTextView.text = "Overweight"
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
            }
            else -> {
                statusTextView.text = "Obese"
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.obese))
            }
        }
    }

    private fun bindViews() {
        weightEditText = findViewById(R.id.weight_edittext)
        heightEditText = findViewById(R.id.height_edittext)
        calculateButton = findViewById(R.id.action_calculate_button)
        calculationTextView = findViewById(R.id.calculation_text_view)
        statusTextView = findViewById(R.id.status_text_view)
    }
}