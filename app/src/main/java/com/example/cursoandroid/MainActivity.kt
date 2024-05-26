package com.example.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<AppCompatEditText>(R.id.editText)
        val btn1= findViewById<AppCompatButton>(R.id.button1)


        btn1.setOnClickListener{
            val text = editText.text.toString()
            if (text.isNotEmpty()){
                Log.i("jorge", "boton pulsado ${text}")
                val intent = Intent(this, resultActivity::class.java)
                intent.putExtra("EXTRA_NAME", text)
                startActivity(intent)
            }

        }
    }
}