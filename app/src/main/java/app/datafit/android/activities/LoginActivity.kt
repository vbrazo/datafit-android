package app.datafit.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import app.datafit.android.App
import app.datafit.android.R
import app.datafit.android.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import app.datafit.android.models.SignUpResponse
import com.amplitude.api.Amplitude

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Amplitude.getInstance().logEvent("Login");

        btnSignUpLink.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        imageViewBack.setOnClickListener {
            this.finish()
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }

        btnSignUp3.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)

            btnNext.startAnimation()

            RetrofitClient.run {
                instance.run {
                    login(txtEmail.text.toString(), txtPassword.text.toString())
                        .enqueue(object: Callback<SignUpResponse> {
                            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                            }

                            override fun onResponse(
                                    call: Call<SignUpResponse>,
                                    response: Response<SignUpResponse>
                                ) {
                                val headers = response.headers()
                                val status = response.code()

                                if (status == 401) {
                                    btnNext.revertAnimation()
                                    Toast.makeText(applicationContext, "Dados Inválidos!", Toast.LENGTH_SHORT).show()
                                } else {
                                    Amplitude.getInstance().userId = txtEmail.text.toString()

                                    App.saveToken(headers["Authorization"]!!)

                                    btnNext.revertAnimation()
                                    startActivity(intent)
                                }
                            }
                        })
                }
            }
        }
    }
}
