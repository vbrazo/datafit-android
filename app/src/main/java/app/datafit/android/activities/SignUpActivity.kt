package app.datafit.android.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.datafit.android.App
import app.datafit.android.R
import app.datafit.android.api.RetrofitClient
import app.datafit.android.models.SignUpResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        loginButtonEvent()
        imageViewBackEvent()
        signUpButtonEvent()
    }

    private fun loginButtonEvent() {
        btnLoginAction.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun imageViewBackEvent() {
        imageViewBack.setOnClickListener {
            this.finish()
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out)
        }
    }

    private fun signUpButtonEvent(){
        val intent = Intent(this, AboutYouActivity::class.java)

        btnNext.setOnClickListener {
            if (txtEmail.text.isEmpty() || txtPassword.text.isEmpty() || txtName.text.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Preencha os campos em branco.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if ((txtPassword.text.toString() == txtPasswordConfirmation.text.toString()).toString() == "false") {
                Toast.makeText(
                    applicationContext,
                    "Os campos de senha precisam ser iguais.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!checkboxTermsAndConditions.isChecked) {
                Toast.makeText(
                    applicationContext,
                    "Você deve aceitar os termos de uso.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!TextUtils.isEmpty(txtEmail.text) && !Patterns.EMAIL_ADDRESS.matcher(txtEmail.text).matches()) {
                Toast.makeText(applicationContext, "E-mail inválido.", Toast.LENGTH_SHORT).show()
            } else {
                RetrofitClient.run {
                    instance.run {
                        createUser(
                            txtEmail.text.toString(),
                            txtPassword.text.toString(),
                            txtName.text.toString()
                        ).enqueue(object : Callback<SignUpResponse> {
                            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                                Toast.makeText(
                                    applicationContext,
                                    t.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            override fun onResponse(
                                call: Call<SignUpResponse>,
                                response: Response<SignUpResponse>
                            ) {
                                if (response.code() == 400) {
                                    Toast.makeText(
                                        applicationContext,
                                        "E-email em uso",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    btnNext.isEnabled = false
                                    val headers = response.headers()
                                    App.saveToken(headers["Authorization"]!!)

                                    startActivity(intent)
                                }
                            }
                        })
                    }
                }
            }
        }
    }
}