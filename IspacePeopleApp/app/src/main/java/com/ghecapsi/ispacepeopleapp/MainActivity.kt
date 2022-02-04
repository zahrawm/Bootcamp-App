package com.ghecapsi.ispacepeopleapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button

import com.ghecapsi.ispacepeopleapp.am.allLearners.AmHomeActivity
import com.ghecapsi.ispacepeopleapp.pm.PmHomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var am_section:Button
    private lateinit var pm_section : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }


        am_section = findViewById(R.id.am_section)
        pm_section = findViewById(R.id.pm_section)

        am_section.setOnClickListener{
            val intent = Intent(this, AmHomeActivity::class.java)
            startActivity(intent)
        }

        pm_section.setOnClickListener {
            val intent = Intent(this, PmHomeActivity::class.java)
            startActivity(intent)
        }
    }
}