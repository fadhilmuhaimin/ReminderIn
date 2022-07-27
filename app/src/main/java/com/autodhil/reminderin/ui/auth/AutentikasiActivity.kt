package com.autodhil.reminderin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.autodhil.reminderin.MainActivity
import com.autodhil.reminderin.R
import com.autodhil.reminderin.databinding.ActivityAdminLoginBinding
import com.autodhil.reminderin.databinding.ActivityAutentikasiBinding
import com.autodhil.reminderin.ui.admin.AdminLoginActivity
import com.autodhil.reminderin.utils.moveIntentTo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AutentikasiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAutentikasiBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutentikasiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvModeAdmin.setOnClickListener {
            moveIntentTo(this,AdminLoginActivity())
        }

    }

    fun masuk(view: View) {
        val id = binding.etIdApotekLogin.text.toString()

        if (!id.equals("")) {
            checkDataLogin(id)
        }
        else {
            Toast.makeText(this, "Masukkan email dan password !", Toast.LENGTH_SHORT).show()
        }
    }

    fun checkDataLogin(id:String) {
        database = FirebaseDatabase.getInstance("https://udrug-24ea7-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Apoteker")
        database.child(id).get().addOnSuccessListener {
            if (it.exists()) {
                Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show()
                moveIntentTo(this,MainActivity())
            } else {
                Toast.makeText(this, "ID tidak terdaftar !", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Masalah koneksi !", Toast.LENGTH_SHORT).show()
        }
    }
}