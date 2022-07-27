package com.autodhil.reminderin.ui.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.autodhil.reminderin.databinding.ActivityRegistAdminBinding
import com.autodhil.reminderin.model.Apoteker
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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
            val pass = binding.etPass.text.toString()

            if (id.equals("")||name.equals("")||pass.equals("")) {
                Toast.makeText(this, "Mohon lengkapi data !", Toast.LENGTH_SHORT).show()
            } else {
                saveData(id,name,pass)
            }

        }
    }

    //NOTE : Belum ditambahkan model admin

    private fun saveData(id : String, name : String, pass : String) {
        database =FirebaseDatabase.getInstance("https://udrug-24ea7-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Apoteker")
        val Apoteker =Apoteker(id, name, pass)
        database.child(id).setValue(Apoteker).addOnCompleteListener {
            Toast.makeText(this,"Simpan data apoteker berhasil",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Gagal simpan data apoteker !",Toast.LENGTH_SHORT).show()
        }
    }
}