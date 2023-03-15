package muhammad.safiul.annam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewWelcome = findViewById<TextView>(R.id.textViewWelcome)

        // Terima data username dari activity login
        val username = intent.getStringExtra("USERNAME")

        textViewWelcome.text = "Welcome, $username!"
    }
}