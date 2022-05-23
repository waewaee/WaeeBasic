package com.waewaee.waeebasic.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_pet_detail.*

class PetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)
        if(intent.hasExtra("Name")){
            tvName.text = intent.getStringExtra("Name")
        }
        if(intent.hasExtra("Color")){
            tvColor.text = intent.getStringExtra("Color")
        }
        if(intent.hasExtra("Weight")){
            tvWeight.text = intent.getLongExtra("Weight",0).toString()
        }
        if(intent.hasExtra("Birthdate")){
            tvBirthdate.text = intent.getStringExtra("Birthdate")
        }
        if(intent.hasExtra("Gender")){
            tvGender.text = intent.getStringExtra("Gender")
        }
        if(intent.hasExtra("Breed")){
            tvBreed.text = intent.getStringExtra("Breed")
        }
        if(intent.hasExtra("HasBabies")){
            tvHasBabies.text = intent.getStringExtra("HasBabies")
        }
        if(intent.hasExtra("Condition")){
            tvCondition.text = intent.getStringExtra("Condition")
        }
    }
}