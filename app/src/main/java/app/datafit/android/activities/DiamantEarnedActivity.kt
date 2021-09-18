package app.datafit.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import app.datafit.android.R
import app.datafit.android.api.RetrofitClient
import app.datafit.android.models.RefreshMapResponse
import com.amplitude.api.Amplitude
import kotlinx.android.synthetic.main.activity_diamant_earned.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiamantEarnedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diamant_earned)

        Amplitude.getInstance().logEvent("Diamond Earned");

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}