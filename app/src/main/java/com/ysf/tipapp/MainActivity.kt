package com.ysf.tipapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ysf.tipapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }

    }


    private fun calculateTip() {
        val stringCostText = binding.costOfService.text.toString()

        val cost: Double? = stringCostText.toDoubleOrNull()
        if (cost != null) {
            val result: Double = when (binding.tipOptions.checkedRadioButtonId) {
                R.id.option_twenty_percent -> 0.2
                R.id.radio_button_2 -> 0.18
                R.id.radio_button_3 -> .15
                R.id.default_selected -> (0.0)
                else -> 0.0
            }
            val tip: Double = (cost * result)
            if (binding.switchId.isChecked) {
                binding.calculatedTip.text = "Tip amount: \$" + kotlin.math.ceil(tip).toString()
            } else {
                val formattedTip="%.2f".format(tip)
                binding.calculatedTip.text = "Tip amount: \$$formattedTip"
            }
        } else {
            binding.calculatedTip.text = "Tip amount: \$" + (0.0).toString()
        }
    }


}