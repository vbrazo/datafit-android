package app.datafit.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import app.datafit.android.App
import app.datafit.android.R

class SplashScreenActivity : AppCompatActivity() {
    private val splashTimeOut:Long = 7500 // 2.5s

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val intent = if (App.getToken().isNotBlank()) {
            Intent(this, GoalActivity::class.java)
        } else {
            Intent(this, WelcomeActivity::class.java)
        }

        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}