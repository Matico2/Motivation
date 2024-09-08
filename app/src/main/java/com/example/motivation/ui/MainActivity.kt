package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var biding: ActivityMainBinding
    private  var categotyId = MotivationConstants.FILTER.ALL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        supportActionBar?.hide()
        handleUserName()
        handleFilter(R.id.image_all)

        //evrentos de click
        biding.buttonNewPrhase.setOnClickListener(this)
        biding.imageAll.setOnClickListener(this)
        biding.imageHappy.setOnClickListener(this)
        biding.imageSunny.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        if (view.id == R.id.button_new_prhase) {
            var s = ""
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)){
            handleFilter(view.id)
        }
    }
    private fun handleFilter(id: Int) {
        biding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        biding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        biding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                biding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categotyId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                biding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categotyId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {biding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categotyId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        biding.textUserName.text = "Olá, $name!"
    }
}