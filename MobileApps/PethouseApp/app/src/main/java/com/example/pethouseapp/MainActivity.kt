package com.example.pethouseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnIniciarSesion.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btnIniciarSesion)
        {
            //Consultar si existe correo electrónico en BD

            if(1 == 1)
            {
                //Si existe en la base de datos, continuar con login.
                val activityIntent = Intent(this, LoginActivity::class.java);
                activityIntent.putExtra("dataLogin", this.tbCorreoElectronico.text.toString());
                startActivity(activityIntent);
            }
            else
            {
                //Si no existe en la base de datos, continuar con registro.

            }



        }
    }


}