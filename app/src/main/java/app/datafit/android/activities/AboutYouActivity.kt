package app.datafit.android.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import app.datafit.android.R
import app.datafit.android.api.RetrofitClient
import app.datafit.android.models.ProfileResponse
import com.amplitude.api.Amplitude
import kotlinx.android.synthetic.main.activity_about_you.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutYouActivity : AppCompatActivity() {
    internal var gender: String  = ""
    internal var goal: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_you)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        buildGenderSpinner()
        buildGoalSpinner()

        txtGoal.bringToFront()
        txtGender.bringToFront()

        Amplitude.getInstance().logEvent("About You");

        val intent = Intent(this, GoalActivity::class.java)

        btnNext.setOnClickListener {
            if (txtHeight.text.isEmpty() || txtWeight.text.isEmpty() ||  txtAge.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Preencha os campos em branco.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                RetrofitClient.run {
                    instance.run {
                        editProfile(
                            txtHeight.text.toString(),
                            txtWeight.text.toString(),
                            txtAge.text.toString(),
                            gender,
                            goal
                        )
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
        }
    }

    private fun buildGoalSpinner() {
        val languages: Array<String> = arrayOf(
            "",
            "Emagrecimento",
            "Ganho de massa muscular",
            "Qualidade de vida"
        )

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.txtGoal)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    (spinner.selectedView as TextView).setTextColor(Color.WHITE)
                    (spinner.selectedView as TextView).textSize = 13f
                    goal = spinner.selectedItem.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun buildGenderSpinner() {
        val languages: Array<String> = arrayOf("", "Feminino", "Masculino")

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.txtGender)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    (spinner.selectedView as TextView).setTextColor(Color.WHITE)
                    (spinner.selectedView as TextView).textSize = 13f
                    gender = spinner.selectedItem.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}
