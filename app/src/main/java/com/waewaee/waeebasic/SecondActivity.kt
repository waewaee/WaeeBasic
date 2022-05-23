package com.waewaee.waeebasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if(intent.hasExtra("Waee")){
            tvShowTwo.text = intent.getStringExtra("Waee")
            tvName.text = intent.getStringExtra("Name")
            tvPhone.text = intent.getStringExtra("Phone")
            tvAge.text = intent.getIntExtra("Age", 0).toString()
            tvEmail.text = intent.getStringExtra("Email")
        }
    }
}