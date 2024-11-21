package com.szs.proyectofinal

import android.content.Context
import android.util.Log
import com.airbnb.lottie.animation.content.Content
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class FileHelper(private val  context: Context) {

    // Leer archivo JSON
    private fun readFile(filename: String): String {
        val file = File(context.filesDir, filename)
        return if (file.exists()) file.readText() else "[]"

    }

    // Escribir en archivo JSON
    private fun writeFile(filename: String, content: String) {
        val file = File(context.filesDir, filename)
        file.writeText(content)
    }

    // Guardar un objeto en un archivo
    fun saveObject(filename: String, jsonObject: JSONObject): Boolean {
        val currentData = JSONArray(readFile(filename))
        currentData.put(jsonObject)
        writeFile(filename, currentData.toString())
        return true
    }



    // Leer todos los objetos de un archivo
    fun readObjetc(filename: String): JSONArray {
        return JSONArray(readFile(filename))
    }
}