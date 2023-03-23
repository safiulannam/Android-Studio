package muhammad.safiul.linktreeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subtitle)
        val list = findViewById<RecyclerView>(R.id.list)

        image.setImageResource(R.drawable.avatar)
        title.text = "Muhammad Safiul Annam"
        subtitle.text = "FullStack Developer"
        list.adapter = linkAdapter
    }
    private val linkAdapter by lazy {
        val items = listOf<LinktreeModel>(
            LinktreeModel("WhatsApp", R.drawable.wa, "https://wa.me/62895374601895"),
            LinktreeModel("Instagram", R.drawable.ig, "https://www.instagram.com/safiulannam/"),
            LinktreeModel("Facebook", R.drawable.fb, "https://facebook.com/Muhammad Safiul Annam"),
            LinktreeModel("YouTube", R.drawable.yt, "https://youtube.com/@muhammadsafiulannam9283"),
            LinktreeModel("Website", R.drawable.web, "https://annam-catering.000webhostapp.com/"),
        )
        LinkAdapter(items, object : LinkAdapter.AdapterListener{
            override fun onClick(link: LinktreeModel) {
                openUrl( link.url )
            }
        })
    }

    private fun openUrl(url: String) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse( url )
        startActivity(openURL)
    }
}