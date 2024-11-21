package com.szs.proyectofinal

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.File
import java.time.Year

class agendarr : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agendarr)
        val fecha: EditText = findViewById(R.id.fecha)
        val Thora: EditText = findViewById(R.id.Thora)
        val nom: EditText = findViewById(R.id.Cusuario)
        val doc: EditText = findViewById(R.id.Cdocumento)
        val pla: EditText = findViewById(R.id.Cplaca)

        val Bagenda: Button = findViewById(R.id.agendar)
        val Bvolver: Button = findViewById(R.id.volver)
        val fileHelper = FileHelper(this)
        val manager = UserManager(this)


        val Bhora: Button = findViewById(R.id.Bhora)



        fecha.setOnClickListener { showDatePickerDialog() }
        Bhora.setOnClickListener() {
            val cal = Calendar.getInstance()
            val hora = cal.get(Calendar.HOUR_OF_DAY)
            val minuto = cal.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                { _, hora, minuto ->
                    // Mostrar la hora seleccionada en el TextView
                    Thora.setText(String.format("%02d:%02d", hora, minuto))
                },
                hora, minuto, true // true para formato de 24 horas, false para 12 horas
            )
            // Mostrar el diálogo
            timePickerDialog.show()

        }



        Bagenda.setOnClickListener() {
            val nombre = nom.text.toString()
            val documento = doc.text.toString()
            val placa = pla.text.toString()
            val hora = Thora.text.toString()
            val fech = fecha.text.toString()

            if (nombre.isNotEmpty() && documento.isNotEmpty() && placa.isNotEmpty() && hora.isNotEmpty() && fech.isNotEmpty()) {
                manager.agendar(this, nombre, documento, placa, hora, fech)
                Toast.makeText(this, "registro con exito", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, citas::class.java))
            } else {
                Toast.makeText(this, "Por favor completar todos las campos", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        Bvolver.setOnClickListener() {
            startActivity(Intent(this, citas::class.java))
            finish()
        }
    }


    private fun showDatePickerDialog() {
        val datePicker= DatePickerFragment {day, month, year-> onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager, "datepiker")
    }

    fun onDateSelected(day: Int,month: Int, year: Int){
        val fecha: EditText = findViewById(R.id.fecha)
        fecha.setText("$day/$month/$year")
    }


}