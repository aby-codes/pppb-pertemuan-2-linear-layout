package com.example.pertemuan_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var bmiScore = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnCount.setOnClickListener {
                calculateBMI()
            }
            btnToast.setOnClickListener{
                val status = when (bmiScore) {
                    in 18.5..24.9 -> "Berat badan normal"
                    in 25.0..29.9 -> "Berat badan berlebih"
                    else -> "Obesitas"
                }
                Toast.makeText(this@MainActivity, "Anda $status", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBMI() {
        val beratStr = binding.beratBadan.text.toString()
        val tinggiStr = binding.tinggiBadan.text.toString()

        if (beratStr.isNotEmpty() && tinggiStr.isNotEmpty()) {
            val berat = beratStr.toFloat()
            val tinggi = tinggiStr.toFloat() / 100

            val bmiScore = berat / (tinggi * tinggi).toDouble()
            val formattedBmi = String.format("%.2f", bmiScore)
            binding.textNumber.text = formattedBmi

            this.bmiScore = formattedBmi.toDouble()
        }
    }
}