package muhammad.safiul.annam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val dialogView = inflater.inflate(R.layout.dialog_login_form, null)

            // Membuat object dialog dengan custom view
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("Login Form")
                .setCancelable(false)
            val dialog = dialogBuilder.show()

            // Mengambil referensi view pada dialog
            val etName = dialogView.findViewById<EditText>(R.id.etName)
            val etEmail = dialogView.findViewById<EditText>(R.id.etEmail)
            val etPassword = dialogView.findViewById<EditText>(R.id.etPassword)
            val buttonSubmit = dialogView.findViewById<Button>(R.id.buttonSubmit)

            buttonSubmit.setOnClickListener {
                // Mengambil input dari user
            val etName = etName.text.toString().trim()
            val etEmail = etEmail.text.toString().trim()
            val etPassword = etPassword.text.toString().trim()

            if (etName.isEmpty() || etEmail.isEmpty() || etPassword.isEmpty()) {
                Toast.makeText(this@LoginActivity, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val intent = intent
                val registerUsername = intent.getStringExtra("Username")
                val registerEmail = intent.getStringExtra("Email")
                val registerPassword = intent.getStringExtra("Password")
                if (etName == registerUsername && etEmail == registerEmail && etPassword == registerPassword) {
                    Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                } else {
                    Toast.makeText(this, "username dan password salah", Toast.LENGTH_SHORT).show()                   }
            }
        }

    }

          }



     }
