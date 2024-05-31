package com.example.cursoandroid.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.cursoandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 25
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvAltura: TextView
    private lateinit var rsSlider: RangeSlider
    private lateinit var btSubstractWeight: FloatingActionButton
    private lateinit var btAddWeight: FloatingActionButton
    private lateinit var tvShowWeight: TextView
    private lateinit var btSubstractAge: FloatingActionButton
    private lateinit var btAddAge: FloatingActionButton
    private lateinit var tvShowAge: TextView
    private lateinit var btCalculate: AppCompatButton

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewFemale = findViewById(R.id.viewFemale)
        viewMale = findViewById(R.id.viewMale)
        tvAltura = findViewById(R.id.tvAltura)
        rsSlider = findViewById(R.id.rsAltura)
        btSubstractWeight = findViewById(R.id.btSubstractWeight)
        btAddWeight = findViewById(R.id.btAddWeight)
        tvShowWeight = findViewById(R.id.tvShowWeight)
        btAddAge = findViewById(R.id.btAddAge)
        btSubstractAge = findViewById(R.id.btSubstractAge)
        tvShowAge = findViewById(R.id.tvShowAge)
        btCalculate = findViewById(R.id.buttonCalculate)

    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsSlider.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvAltura.text = "${result.toString()} cm"
            currentHeight = result.toInt()
        }
        btSubstractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
            

        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100*currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
        
    }

    private fun setWeight() {
        tvShowWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvShowAge.text = currentAge.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
}