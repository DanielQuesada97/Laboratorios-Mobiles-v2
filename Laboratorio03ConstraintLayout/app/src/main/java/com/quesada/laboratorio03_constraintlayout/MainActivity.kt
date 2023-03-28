package com.quesada.laboratorio03_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.math.BigDecimal
import kotlin.math.roundToInt

private lateinit var fiveCentImageView: ImageView
private lateinit var tenCentImageView: ImageView
private lateinit var twentyFiveCentImageView: ImageView
private lateinit var dollarImageView: ImageView
private lateinit var quantityTextView: TextView

//Data
private var total = BigDecimal("0.00")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        onClickListeners()

    }

    private fun onClickListeners() {
        fiveCentImageView.setOnClickListener {
            total += BigDecimal("0.05")
            quantityTextView.text = total.toString()
        }
        tenCentImageView.setOnClickListener {
            total += BigDecimal("0.10")
            quantityTextView.text = total.toString()
        }
        twentyFiveCentImageView.setOnClickListener {
            total += BigDecimal("0.25")
            quantityTextView.text = total.toString()
        }
        dollarImageView.setOnClickListener {
            total += BigDecimal("1.00")
            quantityTextView.text = total.toString()
        }
    }

    private fun bind() {
        fiveCentImageView = findViewById(R.id.fiveCentImageView)
        tenCentImageView = findViewById(R.id.tenCentImageView)
        twentyFiveCentImageView = findViewById(R.id.twentyFiveCentImageView)
        dollarImageView = findViewById(R.id.OneDollarImageView)
        quantityTextView = findViewById(R.id.total_textView)
    }
}
