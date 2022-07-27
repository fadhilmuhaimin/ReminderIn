package com.autodhil.reminderin.ui.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.autodhil.reminderin.R
import com.autodhil.reminderin.databinding.ActivityAdminLoginBinding
import com.autodhil.reminderin.ui.auth.AutentikasiActivity
import com.google.firebase.auth.FirebaseAuth

class AdminLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAdminLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        binding.btnLoginAdmin.setOnClickListener {
            val email = binding.etEmailAdmin.text.toString()
            val pass = binding.etPassAdmin.text.toString()

            if (email!=null && pass!=null) {
                checkDataAdmin(email, pass)
            }
            else {
                Toast.makeText(this, "Masukkan email dan password !", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvToMainLogin.setOnClickListener {
            startActivity(Intent(this, AutentikasiActivity::class.java))
        }
    }

    private fun checkDataAdmin(email: String, pass: String) {
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { taskId ->
            if (taskId.isSuccessful) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AdminMainActivity::class.java))
            } else {
                Toast.makeText(this, "Login gagal !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}