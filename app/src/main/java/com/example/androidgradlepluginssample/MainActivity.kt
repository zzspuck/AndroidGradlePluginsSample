package com.example.androidgradlepluginssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvSubmit).setOnClickListener {
            showMainActivity()
        }
    }

    public fun showMainActivity(){
        findViewById<TextView>(R.id.tvSubmit).text = "HA HA I CLICK MainActivity"
    }
}