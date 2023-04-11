package com.quesada.laboratorio03_activitylifecycleandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var mailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var shareButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        bind()

        nameTextView.text = intent.getStringExtra("nombre").toString()
        mailTextView.text = intent.getStringExtra("correo").toString()
        phoneTextView.text = intent.getStringExtra("numero").toString()

        val content = nameTextView.text.toString() + "\n"+
                mailTextView.text.toString() + "\n"+
                phoneTextView.text.toString()

        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, content)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


    }

    private fun bind() {
        nameTextView = findViewById(R.id.nameTextView)
        mailTextView = findViewById(R.id.emailTextView)
        phoneTextView = findViewById(R.id.PhoneTextView)
        shareButton = findViewById(R.id.shareButton)
    }
}