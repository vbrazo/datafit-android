package app.datafit.android.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.datafit.android.R
import com.amplitude.api.Amplitude
import com.google.android.material.card.MaterialCardView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ViewListener
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Amplitude.getInstance().logEvent("Welcome");

        val carouselView = findViewById<CarouselView>(R.id.carouselView)
        carouselView.pageCount = sampleImages.size
        carouselView.setViewListener(viewListener)
        carouselView.slideInterval = 8000

        btnLoginAction.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private var sampleImages = intArrayOf(
        R.drawable.welcome_image_4,
        R.drawable.welcome_image_5,
        R.drawable.welcome_image_3
    )

    private var sampleTitles: Array<String> = arrayOf(
        "A sua academia digital",
        "Missões personalizadas",
        "Seja desafiado todos os dias"
    )

    private var sampleDescriptions: Array<String> = arrayOf(
        "Treine com as missões da academia digital da DataFit e mantenha-se em forma.",
        "Através do seu perfil e do seu histórico, o app personaliza as suas missões com desafios ideais para você.",
        "Ganhe diamantes ao completar objetivos. Troque diamantes por items na loja da DataFit."
    )

    // To set custom views
    var viewListener = ViewListener { position ->
        val customView = layoutInflater.inflate(R.layout.view_custom, null)
        val labelTitle = customView.findViewById<View>(R.id.labelTitle) as TextView
        val labelDescription = customView.findViewById<View>(R.id.labelDescription) as TextView
        val imageView = customView.findViewById<View>(R.id.fruitImageView) as ImageView
        val firstSelector = customView.findViewById<View>(R.id.firstSelector) as MaterialCardView
        val secondSelector = customView.findViewById<View>(R.id.secondSelector) as MaterialCardView
        val thirdSelector = customView.findViewById<View>(R.id.thirdSelector) as MaterialCardView

        when (position) {
            0 -> {
                firstSelector.setCardBackgroundColor(Color.parseColor("#F9F9F9"))
                secondSelector.setCardBackgroundColor(Color.parseColor("#585D66"))
                thirdSelector.setCardBackgroundColor(Color.parseColor("#585D66"))
                labelDescription.height = 30
            }
            1 -> {
                firstSelector.setCardBackgroundColor(Color.parseColor("#585D66"))
                secondSelector.setCardBackgroundColor(Color.parseColor("#F9F9F9"))
                thirdSelector.setCardBackgroundColor(Color.parseColor("#585D66"))
                labelDescription.height = 60
            }
            2 -> {
                firstSelector.setCardBackgroundColor(Color.parseColor("#585D66"))
                secondSelector.setCardBackgroundColor(Color.parseColor("#585D66"))
                thirdSelector.setCardBackgroundColor(Color.parseColor("#F9F9F9"))
                labelDescription.height = 30
            }
        }

        imageView.setImageResource(sampleImages[position])

        labelTitle.text = sampleTitles[position]
        labelDescription.text = sampleDescriptions[position]

        customView
    }
}