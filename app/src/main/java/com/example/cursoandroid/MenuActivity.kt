package com.example.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cursoandroid.imccalculator.ImcActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btSaludar = findViewById<Button>(R.id.btnSaludar)
        btSaludar.setOnClickListener {navigateToSaludar()}
        val btImc = findViewById<Button>(R.id.btnCalculadoraIMC)
        btImc.setOnClickListener { navigateToImcCalculator() }
    }

    private fun navigateToSaludar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToImcCalculator(){
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }
}