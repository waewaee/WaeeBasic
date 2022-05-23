package com.waewaee.waeebasic.picker

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_date_picker.*

class DatePickerActivity : AppCompatActivity() {
    var showDatePicker = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        tvChosenDate.text = "Current Date: ${pickDate()}"
        btnChoose.setOnClickListener {
            if (showDatePicker) {
                tvChosenDate.text = "Chosen Date: ${pickDate()}"
            } else {
                tvChosenDate.text = "Chosen Time: ${pickTime()}"
            }
        }

        btnChange.setOnClickListener {
            if(showDatePicker){
                tvChosenDate.text = "Current Time: ${pickTime()}"
                btnChange.text = "Show Date Picker"
                datePicker.visibility = View.GONE
                timePicker.visibility = View.VISIBLE
                showDatePicker = false
            } else {
                tvChosenDate.text = "Current Date: ${pickDate()}"
                btnChange.text = "Show Time Picker"
                datePicker.visibility = View.VISIBLE
                timePicker.visibility = View.GONE
                showDatePicker = true
            }
        }
    }


    fun pickDate():String{
        var day = datePicker.dayOfMonth
        var month = datePicker.month+1
        var year = datePicker.year
        return "$day-$month-$year"
    }

    fun pickTime():String{
        var status = ""
        var hour = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.hour
        } else {
            timePicker.currentHour
        }

        var minute = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.minute
        } else {
            timePicker.currentMinute
        }

        if(hour>=12){
            hour -= 12
            status = "PM"
        } else {
            status = "AM"
        }

        return "$hour : $minute $status"

    }
}