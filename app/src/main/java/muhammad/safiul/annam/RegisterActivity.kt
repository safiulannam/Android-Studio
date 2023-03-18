package muhammad.safiul.annam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            // Membuat object inflater untuk dialog form
            val inflater = LayoutInflater.from(this)
            val dialogView = inflater.inflate(R.layout.dialog_register_form, null)

            // Membuat object dialog dengan custom view
            val dialogBuilder = AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle("Konfirmasi Registrasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ -> super.onBackPressed() }
                .setNegativeButton("Tidak", null)
            val dialog = dialogBuilder.show()

            // Mengambil referensi view pada dialog
            val etName = dialogView.findViewById<EditText>(R.id.etName)
            val etEmail = dialogView.findViewById<EditText>(R.id.etEmail)
            val etPassword = dialogView.findViewById<EditText>(R.id.etPassword)
            val etConfirmPassword = dialogView.findViewById<EditText>(R.id.etConfirmPassword)
            val buttonSubmit = dialogView.findViewById<Button>(R.id.buttonSubmit)

            buttonSubmit.setOnClickListener {
                // Mengambil input dari user
                val etName = etName.text.toString().trim()
                val etEmail = etEmail.text.toString().trim()
                val etPassword = etPassword.text.toString().trim()
                val confirmPassword = etConfirmPassword.text.toString().trim()

                if (etName.isEmpty() || etEmail.isEmpty() || etPassword.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(this, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                } else if (etPassword != confirmPassword) {
                    Toast.makeText(this, "Sandi tidak cocok", Toast.LENGTH_SHORT).show()
                } else {
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        intent.putExtra("Name", etName)
                        intent.putExtra("email", etEmail)
                        intent.putExtra("password", etPassword)
                        startActivity(intent)
                        dialog.dismiss()
                        finish()
                    }
                }
            }
        }
    }