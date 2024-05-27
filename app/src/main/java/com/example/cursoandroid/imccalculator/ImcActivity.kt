package com.example.cursoandroid.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.cursoandroid.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false


    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvAltura:TextView
    private lateinit var rsSlider:RangeSlider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
        initUI()


    }

    private fun initUI() {
        setGenderColor()
    }
    private fun initComponents() {
        viewFemale = findViewById(R.id.viewFemale)
        viewMale = findViewById(R.id.viewMale)
        tvAltura = findViewById(R.id.tvAltura)
        rsSlider = findViewById(R.id.rsAltura)

    }
    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()}
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()}
        rsSlider.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvAltura.text = "${result.toString()} cm" }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent: Boolean): Int{
        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

}