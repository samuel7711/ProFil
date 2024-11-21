package com.szs.proyectofinal

import android.R
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class UserManager(context: Context){

    private val sharedPreferences: SharedPreferences=context.getSharedPreferences("usuarios",
        Context.MODE_PRIVATE
    )


    fun registrar(nombre: String, contraseña: String, correo: String, telefono: String){
        val editor = sharedPreferences.edit()
        editor.putString("nombre", nombre)
        editor.putString("contraseña", contraseña)
        editor.putString("correo", correo)
        editor.putString("telefono",telefono)
        editor.apply()
    }

    fun login(correo: String, contraseña: String): Boolean{
        val saveCorreo = sharedPreferences.getString("correo",null)
        val saveContraseña = sharedPreferences.getString("contraseña",null)

        return saveCorreo== correo && saveContraseña==contraseña
    }

    fun agendar(context: Context,nombre: String, documento: String, placa: String, hora: String, fecha: String){
        val edi = sharedPreferences.edit()
        edi.putString("nombre", nombre)
        edi.putString("documento",documento)
        edi.putString("placa", placa)
        edi.putString("hora", hora)
        edi.putString("fecha",fecha)
        edi.apply()
    }

    fun mostrarCita(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("Citas", Context.MODE_PRIVATE)

        val documento = sharedPreferences.getString("documento", null)
        val placa = sharedPreferences.getString("placa", null)
        val fecha = sharedPreferences.getString("fecha", null)
        val hora = sharedPreferences.getString("hora", null)

        if (documento == null || placa == null || fecha == null || hora == null) {
            Log.w("MostrarCita", "Datos incompletos: Documento=$documento, Placa=$placa, Fecha=$fecha, Hora=$hora")
        } else {
            Log.d("MostrarCita", "Datos recuperados: Documento=$documento, Placa=$placa, Fecha=$fecha, Hora=$hora")
        }

        Log.d("MostrarCita", "Documento=$documento, Placa=$placa, Fecha=$fecha, Hora=$hora")

        return "Documento: $documento\nPlaca: $placa\nFecha: $fecha\nHora: $hora"
    }
}