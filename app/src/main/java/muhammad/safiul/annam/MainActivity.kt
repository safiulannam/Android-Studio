package muhammad.safiul.annam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById<Button>(R.id.btnLogin)
        btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            showLoginDialog()
        }

        btnRegister.setOnClickListener {
            showRegisterDialog()
        }

        btnLogin.setOnClickListener {

            val etName = etName.text.toString()
            val etEmail = etEmail.text.toString()
            val etPassword = etPassword.text.toString()

            if (etEmail.isNotEmpty() && etPassword.isNotEmpty()) {
                // lakukan pengecekan login
                if (etEmail == "example@gmail.com" && etPassword == "123456") {
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    intent.putExtra("email", intent.getStringExtra("email"))
                    startActivity(intent)
                    finish()
                } else {
                    showErrorDialog("Email atau password salah!")
                }
            } else {
                showErrorDialog("Silakan lengkapi data login!")
            }
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showErrorDialog(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    private fun showLoginDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_login_form, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("Login") { dialog, _ ->
                val etName = dialogView.findViewById<EditText>(R.id.etName)
                val etPassword = dialogView.findViewById<EditText>(R.id.etPassword)

                // Lakukan proses login
                // ...

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showRegisterDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_register_form, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("Register") { dialog, _ ->
                val etName = dialogView.findViewById<EditText>(R.id.etName)
//                val etEmail = dialogView.findViewById<EditText>(R.id.etEmail)
                val etPassword = dialogView.findViewById<EditText>(R.id.etPassword)
//                val etConfirmPassword = dialogView.findViewById<EditText>(R.id.etConfirmPassword)

                // Validasi form
                if (etName.text.toString().isEmpty()) {
                    Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                } else if (etEmail.text.toString().isEmpty()) {
                    Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                } else {
                    (etPassword.text.toString().isEmpty())
                    Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }
            }
    }
}