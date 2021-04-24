package com.example.pethouseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        val strCorreoElectronico:String = intent.getStringExtra("dataLogin").toString();

        this.tbCorreoElectronico.setText(strCorreoElectronico);
    }
}