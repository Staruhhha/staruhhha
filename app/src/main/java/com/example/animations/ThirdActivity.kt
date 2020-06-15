package com.example.animations

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    lateinit var anim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Blink.setOnClickListener {

            anim = AnimationUtils.loadAnimation(this,    R.anim.blink)
                imageView2.startAnimation(anim)
        }
        Spin.setOnClickListener {
            anim = AnimationUtils.loadAnimation(this,    R.anim.spin)
            imageView2.startAnimation(anim)
        }
        GoBack1.setOnClickListener {
            val mainIntnent = Intent (this, MainActivity::class.java)
            startActivity(mainIntnent)
        }
    }

}
