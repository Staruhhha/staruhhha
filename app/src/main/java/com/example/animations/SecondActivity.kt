package com.example.animations

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    lateinit var anim : AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        StartDance.setOnClickListener {
            (imageView.background as AnimationDrawable).start()
        }
        EndDance.setOnClickListener {
            (imageView.background as AnimationDrawable).stop()
        }
        GoBack.setOnClickListener {
            val mainIntent = Intent (this, MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}
