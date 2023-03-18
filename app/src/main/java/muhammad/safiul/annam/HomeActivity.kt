package muhammad.safiul.annam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val etName = intent.getStringExtra("NAME")
        val etEmail = intent.getStringExtra("email")

    }
}