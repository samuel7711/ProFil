package com.szs.proyectofinal

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar

class DatePickerFragment(val listener:(day: Int, month: Int,year: Int,)-> Unit): DialogFragment(),
DatePickerDialog.OnDateSetListener{
    override fun onDateSet(
        view: DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        listener(dayOfMonth,month,year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val  day = c.get(Calendar.DAY_OF_MONTH)
        val  month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context,this, year, month, day)
        picker.datePicker.minDate =c.timeInMillis
        return picker
    }
}

class TimePickerFragment(val listener: (hour: Int, minute: Int) -> Unit): DialogFragment(), TimePickerDialog.OnTimeSetListener{


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute= c.get(Calendar.MINUTE)

        val time = TimePickerDialog(activity as Context,this, hour, minute,true)
        return time

    }

    override fun onTimeSet(view: TimePicker?, hora: Int, minuto: Int) {
        listener(hora,minuto)

    }


}