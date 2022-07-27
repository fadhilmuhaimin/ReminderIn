package com.autodhil.reminderin.ui.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.autodhil.reminderin.R
import com.autodhil.reminderin.databinding.ActivityAdminMainBinding
import com.autodhil.reminderin.ui.auth.AutentikasiActivity

class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAdminMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnRegist.setOnClickListener {
            startActivity(Intent(this, AdminRegistActivity::class.java))
        }

        binding.btnLihatData.setOnClickListener{
            Toast.makeText(this, "Tahap pengembangan", Toast.LENGTH_SHORT).show()
        }

        binding.btnUpdateData.setOnClickListener {
            Toast.makeText(this, "Tahap pengembangan", Toast.LENGTH_SHORT).show()
        }

        binding.btnHapusData.setOnClickListener {
            Toast.makeText(this, "Tahap pengembangan", Toast.LENGTH_SHORT).show()
        }
    }
}