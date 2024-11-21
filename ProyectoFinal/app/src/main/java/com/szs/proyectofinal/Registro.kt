package com.szs.proyectofinal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        val registrar: Button = findViewById(R.id.Registrar)
        val fileHelper = FileHelper(this)

        val manager = UserManager(this)

        val edtContra = findViewById<EditText>(R.id.Rcontraseña).text.toString()
        val edtCorreo = findViewById<EditText>(R.id.Rcorreo).text.toString()
        val edtTelefono = findViewById<EditText>(R.id.Rtelefono).text.toString()
        val edtNombre = findViewById<EditText>(R.id.Rusuario).text.toString()

        registrar.setOnClickListener() {
            val edtContra = findViewById<EditText>(R.id.Rcontraseña)
            val edtCorreo = findViewById<EditText>(R.id.Rcorreo)
            val edtTelefono = findViewById<EditText>(R.id.Rtelefono)
            val edtNombre = findViewById<EditText>(R.id.Rusuario)

            val nombre = edtNombre.text.toString().trim()
            val correo = edtCorreo.text.toString().trim()
            val contrase = edtContra.text.toString().trim()
            val telefono = edtTelefono.text.toString().trim()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && contrase.isNotEmpty() && telefono.isNotEmpty()) {
                manager.registrar(nombre, contrase, correo, telefono)
                Toast.makeText(this, "registro con exito", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, citas::class.java))
            }else{
                Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
            }
            
        }

    }


}