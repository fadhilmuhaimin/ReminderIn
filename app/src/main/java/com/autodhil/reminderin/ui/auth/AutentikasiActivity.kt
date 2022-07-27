package com.autodhil.reminderin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.autodhil.reminderin.MainActivity
import com.autodhil.reminderin.R
import com.autodhil.reminderin.databinding.ActivityAdminLoginBinding
import com.autodhil.reminderin.databinding.ActivityAutentikasiBinding
import com.autodhil.reminderin.ui.admin.AdminLoginActivity
import com.autodhil.reminderin.utils.moveIntentTo

class AutentikasiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAutentikasiBinding

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
        moveIntentTo(this,MainActivity())
    }
}