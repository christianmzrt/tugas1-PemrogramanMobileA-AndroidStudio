package com.richard.helloworld

import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ambil referensi view
        val tvHello = findViewById<TextView>(R.id.tvHello)
        val tvNama  = findViewById<TextView>(R.id.tvNama)
        val tvNIM   = findViewById<TextView>(R.id.tvNIM)
        val tvEmoji = findViewById<TextView>(R.id.tvEmoji)

        // Animasi fade-in bertahap
        fadeIn(tvEmoji, 0)
        fadeIn(tvHello, 300)
        fadeIn(tvNama,  600)
        fadeIn(tvNIM,   900)

        // Animasi scale pada emoji
        val scaleX = ObjectAnimator.ofFloat(tvEmoji, "scaleX", 0f, 1f).apply { duration = 500 }
        val scaleY = ObjectAnimator.ofFloat(tvEmoji, "scaleY", 0f, 1f).apply { duration = 500 }
        AnimatorSet().apply {
            playTogether(scaleX, scaleY)
            start()
        }
    }

    // Fungsi helper animasi fade-in dengan delay
    private fun fadeIn(view: android.view.View, delayMs: Long) {
        val anim = AlphaAnimation(0f, 1f).apply {
            duration    = 600
            startOffset = delayMs
            fillAfter   = true   // ✅ Langsung set di sini, tidak perlu extension function
        }
        view.startAnimation(anim)
    }
}