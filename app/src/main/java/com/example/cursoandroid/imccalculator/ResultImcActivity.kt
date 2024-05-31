package com.example.cursoandroid.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.cursoandroid.R
import com.example.cursoandroid.imccalculator.ImcActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {

    private lateinit var tvType:TextView
    private lateinit var tvResult: TextView
    private lateinit var tvDescription:TextView
    private lateinit var btRecalculate: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btRecalculate.setOnClickListener{
            onBackPressed()
        }
    }

    private fun initUI(result:Double) {
        when(result){
            in 0.00..18.50 ->{
                tvType.text = "BAJO"
                tvType.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvResult.text = result.toString()
                tvDescription.text = "tienes un indice de masa corporal BAJO"
            }
            in 18.51..24.99 ->{
                tvType.text = "NORMAL"
                tvType.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvResult.text = result.toString()
                tvDescription.text = "tienes un indice de masa corporal NORMAL"
            }
            in 25.00..29.99 ->{
                tvType.text = "SOBREPESO"
                tvType.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvResult.text = result.toString()
                tvDescription.text = "tienes un indice de masa corporal SOBREPESO"
            }
            in 30.00..99.00 ->{
                tvType.text = "OBESIDAD"
                tvType.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvResult.text = result.toString()
                tvDescription.text = "tienes un indice de masa corporal muy alto bajale a las tortillas"
            }
            else -> {
                tvType.text = "ERROR"
                tvResult.text = "ERROR"
                tvDescription.text = "ERROR"
            }

        }
    }

    private fun initComponents() {
        tvType = findViewById(R.id.tvType)
        tvResult = findViewById(R.id.tvImc)
        tvDescription = findViewById(R.id.tvDescription)
        btRecalculate = findViewById(R.id.buttonReCalculate)
    }
}