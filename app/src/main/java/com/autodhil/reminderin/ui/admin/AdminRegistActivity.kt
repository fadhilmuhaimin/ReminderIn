package com.autodhil.reminderin.ui.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.autodhil.reminderin.databinding.ActivityRegistAdminBinding
import com.google.firebase.database.DatabaseReference

class AdminRegistActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistAdminBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistAdminBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.imgBack.setOnClickListener {
            startActivity(Intent(this, AdminMainActivity::class.java))
        }

        binding.btnSaveData.setOnClickListener{
            val id = binding.etId.text.toString()
            val name = binding.etNama.text.toString()
            val jabatan = binding.etJabatan.text.toString()
        }
    }

    //NOTE : Belum ditambahkan model admin

    private fun SaveData() {

    }
}