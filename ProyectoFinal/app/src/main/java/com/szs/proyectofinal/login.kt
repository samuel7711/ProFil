package com.szs.proyectofinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val Blogin: Button = findViewById(R.id.Blogin)
        val Bregistro: Button = findViewById(R.id.Bregistro)
        val corre: EditText = findViewById(R.id.correo)
        val contrase: EditText = findViewById(R.id.contraseña)
        val fileHelper = FileHelper(this)
        val manager = UserManager(this)

        Blogin.setOnClickListener(){
            val correo = corre.text.toString()
            val contraseña = contrase.text.toString()

            if (correo.isNotEmpty() && contraseña.isNotEmpty()){
                if (manager.login(correo,contraseña)){
                    Toast.makeText(this, "inicio de sesion exitoso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, citas::class.java))
                }else{
                    Toast.makeText(this, "Correo u contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Por favor, Completar los campos", Toast.LENGTH_SHORT).show()
            }

        }

        Bregistro.setOnClickListener(){
            startActivity(Intent(this, Registro::class.java))
            finish()
        }

    }
}