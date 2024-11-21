package com.szs.proyectofinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog


class citas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_citas)

        val Bagendar: Button = findViewById(R.id.Bagendar)
        val Bcerrar: Button = findViewById(R.id.cerrar)
        val mostrar: TextView = findViewById(R.id.cita)
        val mos: Button=findViewById(R.id.mostrar)
        val manager = UserManager(this)

        mos.setOnClickListener(){
            val cita=manager.mostrarCita(this)
            mostrar.text=cita
        }







        Bagendar.setOnClickListener() {
            startActivity(Intent(this, agendarr::class.java))
        }

        Bcerrar.setOnClickListener() {
            showDialog()
        }

    }

    private fun showDialog() {
        // Crear el diálogo
        val builder = AlertDialog.Builder(this)
        builder.setTitle("CERRAR SESIÓN")
        builder.setMessage("¿Estas seguro de que deseas cerrar sesión?")

        builder.setPositiveButton("Aceptar"){
            dialog,_-> dialog.dismiss()
            Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, login::class.java))
            finish()
        }

        builder.setNegativeButton("Cancelar"){
            dialog,_-> dialog.dismiss()
        }

        builder.create().show()

    }

}