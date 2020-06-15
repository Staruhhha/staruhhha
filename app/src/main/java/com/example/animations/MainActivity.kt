package com.example.animations

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Frame.setOnClickListener {
            val frameIntent = Intent (this, SecondActivity ::class.java)
            startActivity(frameIntent)
        }
        Tween.setOnClickListener {
            val tweenIntent = Intent (this, ThirdActivity::class.java)
            startActivity(tweenIntent)
        }
    }
}
