package muhammad.safiul.annam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")

        editTextUsername.setText(username)
        editTextPassword.setText(password)

        buttonLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
            }
        }
    }