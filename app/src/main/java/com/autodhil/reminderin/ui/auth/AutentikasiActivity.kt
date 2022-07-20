package com.autodhil.reminderin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.autodhil.reminderin.MainActivity
import com.autodhil.reminderin.R
import com.autodhil.reminderin.utils.moveIntentTo

class AutentikasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autentikasi)
    }

    fun masuk(view: View) {
        moveIntentTo(this,MainActivity())
    }
}