package online.asaphmwangi.garimpya.authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import online.asaphmwangi.garimpya.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cardView = findViewById<CardView>(R.id.login_card)


        cardView.apply {
            // Start from 0 opacity and 0.8x scale

            scaleX = 0.8f
            scaleY = 0.8f
            visibility = View.VISIBLE

            // Animate to full opacity and normal scale
            animate()

                .scaleX(1f)
                .scaleY(1f)
                .setDuration(1000) // duration in ms
                .start()
        }
    }
    fun loadSignUpActivity(view: View)
    {
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}