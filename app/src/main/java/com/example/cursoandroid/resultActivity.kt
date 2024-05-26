package com.example.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResults)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text= "hola ${name}"
    }
}