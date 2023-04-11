package com.quesada.laboratorio03_activitylifecycleandintents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameTextField: TextInputEditText
    private lateinit var mailTextField: TextInputEditText
    private lateinit var phoneTextField: TextInputEditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        saveButton.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("nombre",nameTextField.text.toString())
            intent.putExtra("correo",mailTextField.text.toString())
            intent.putExtra("numero",phoneTextField.text.toString())
            startActivity(intent) }
    }
    private fun bind(){
        nameTextField = findViewById(R.id.nameTextField2)
        mailTextField = findViewById(R.id.mailTextField2)
        phoneTextField = findViewById(R.id.phoneTextField2)
        saveButton = findViewById(R.id.saveButton)
    }

}