package app.datafit.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import app.datafit.android.R
import app.datafit.android.api.RetrofitClient
import app.datafit.android.models.ProfileResponse
import com.amplitude.api.Amplitude
import kotlinx.android.synthetic.main.activity_frequency.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FrequencyActivity : AppCompatActivity() {
    var days: MutableList<String> = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frequency)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)

        Amplitude.getInstance().logEvent("Sign up - Days of Rest");

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        imageViewBack.setOnClickListener {
            this.finish()
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, DiamantEarnedActivity::class.java)

            RetrofitClient.run {
                instance.run {
                    editFrequency(days.joinToString(separator = ","))
                        .enqueue(object : Callback<ProfileResponse> {
                            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                                Toast.makeText(
                                    applicationContext,
                                    t.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            override fun onResponse(
                                call: Call<ProfileResponse>,
                                response: Response<ProfileResponse>
                            ) {
                                startActivity(intent)
                            }
                        })
                }
            }
        }

        btnMonday.setOnClickListener {
            if ("Monday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Monday") {
                        days.removeAt(index)
                    }
                }
                btnMonday.isChecked = false
            } else {
                days.add("Monday")
            }
        }

        btnTuesday.setOnClickListener {
            if ("Tuesday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Tuesday") {
                        days.removeAt(index)
                    }
                }
                btnTuesday.isChecked = false
            } else {
                days.add("Tuesday")
            }
        }

        btnWednesday.setOnClickListener {
            if ("Wednesday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Wednesday") {
                        days.removeAt(index)
                    }
                }
                btnWednesday.isChecked = false
            } else {
                days.add("Wednesday")
            }
        }

        btnThursday.setOnClickListener {
            if ("Thursday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Thursday") {
                        days.removeAt(index)
                    }
                }
                btnThursday.isChecked = false
            } else {
                days.add("Thursday")
            }
        }

        btnFriday.setOnClickListener {
            if ("Friday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Friday") {
                        days.removeAt(index)
                    }
                }
                btnFriday.isChecked = false
            } else {
                days.add("Friday")
            }
        }

        btnSaturday.setOnClickListener {
            if ("Saturday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Saturday") {
                        days.removeAt(index)
                    }
                }
                btnSaturday.isChecked = false
            } else {
                days.add("Saturday")
            }
        }

        btnSunday.setOnClickListener {
            if ("Sunday" in days) {
                for ((index, value) in days.withIndex()) {
                    if (value == "Sunday") {
                        days.removeAt(index)
                    }
                }
                btnSunday.isChecked = false
            } else {
                days.add("Sunday")
            }
        }
    }
}