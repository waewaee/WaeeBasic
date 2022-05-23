package com.waewaee.waeebasic.picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_date_picker_dialog.*
import java.util.*

class DatePickerDialogActivity : AppCompatActivity() {
    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker_dialog)
        var calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        btnChooseDate.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                tvDate.text = "$dayOfMonth-${month+1}-$year"
            },
                year, month, day).show()
        }

        btnChooseTime.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tvTime.text = "$hourOfDay-$minute"
            }, hour, minute, false).show()
        }

    }
}