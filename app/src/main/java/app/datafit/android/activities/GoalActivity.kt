package app.datafit.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import app.datafit.android.App
import app.datafit.android.R
import app.datafit.android.api.RetrofitClient
import app.datafit.android.models.ProfileResponse
import com.amplitude.api.Amplitude
import kotlinx.android.synthetic.main.activity_goal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)

        Amplitude.getInstance().logEvent("Sign up - Level");

        val intent = Intent(this, FrequencyActivity::class.java)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        imageViewBack.setOnClickListener {
            this.finish()
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }

        btnNext.setOnClickListener {
            if (btnAdvanced.isChecked || btnBegineer.isChecked || btnIntermediate.isChecked) {
                var level = "Iniciante"

                if (btnAdvanced.isChecked) {
                    level = "Avançado"
                }

                if (btnBegineer.isChecked) {
                    level = "Iniciante"
                }

                if (btnIntermediate.isChecked) {
                    level = "Intermediário"
                }

                App.saveLevel(level)

                RetrofitClient.run {
                    instance.run {
                        editLevel(level).enqueue(object : Callback<ProfileResponse> {
                            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                            }

                            override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {
                                startActivity(intent)
                            }
                        })
                    }
                }
            } else {
                Toast.makeText(applicationContext, "Selecione uma opção", Toast.LENGTH_SHORT).show()
            }
        }
    }
}