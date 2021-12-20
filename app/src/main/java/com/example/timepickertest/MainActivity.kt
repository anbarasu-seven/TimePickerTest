package com.example.timepickertest

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timePicker = findViewById<TimePicker>(R.id.timepickerId)
        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            showToast(hourOfDay,minute)
        }

        val datetime = Calendar.getInstance()
        findViewById<Button>(R.id.popup).setOnClickListener {
                val timePickrDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    showToast(hourOfDay, minute)
                }, datetime.get(Calendar.HOUR_OF_DAY), datetime.get(Calendar.MINUTE), false)
            timePickrDialog.show()
        }

    }

    private fun showToast(hourOfDay: Int, minute: Int) {
        var hour = 0
        var format = "AM"
        if (hourOfDay == 0) {
            hour = 12
            format = "AM"
        } else if (hourOfDay < 12) {
            hour = hourOfDay
            format = "AM"
        } else if (hourOfDay == 12) {
            hour = 12
            format = "PM"
        } else if (hourOfDay > 12) {
            hour = hourOfDay - 12
            format = "PM"
        }

        Toast.makeText(this, "$hour : $minute $format", Toast.LENGTH_SHORT).show()
    }
}