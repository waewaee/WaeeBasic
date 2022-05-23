package com.waewaee.waeebasic.homework

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_date_picker_dialog.*
import kotlinx.android.synthetic.main.activity_pet.*
import kotlinx.android.synthetic.main.activity_pet_detail.*
import kotlinx.android.synthetic.main.activity_pet_detail.tvColor
import kotlinx.android.synthetic.main.spinner_color.*
import java.util.*

class PetActivity : AppCompatActivity() {
    var year = 0
    var month = 0
    var day = 0
    var name = ""
    var color = ""
    var weight: Long = 0
    var birthDate = ""
    var gender = ""
    var breed = ""
    var hasBabies = false
    var condition = ""
    var colorList = arrayOf("Choose a color", "Brown", "White", "Black", "Yellow", "Orange")
    var chosenColor = ""
    var colorIdList = arrayOf(R.color.md_blue_100, R.color.md_brown_500, R.color.white, R.color.black, R.color.md_yellow_500, R.color.md_deep_orange_400 )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet)
        var calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        tvAge.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                birthDate = "$dayOfMonth-${month+1}-$year"
                tvAge.text = birthDate
            },
                year, month, day).show()
        }

//        val aa: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.spinner_color, R.id.tvColor, colorList)
        var adapter = ColorArrayAdapter(this, colorList, colorIdList)
//        spinnerColor.adapter = aa
        spinnerColor.adapter = adapter
        spinnerColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                chosenColor = ""
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position>0){
                    chosenColor = colorList[position]
                } else {
                    chosenColor = ""
                }
            }

        }

        btnRegister.setOnClickListener {
            when {
                etPetName.text.toString().isEmpty() -> {
                    etPetName.error = "Enter a name!"
                }
                chosenColor.isEmpty() -> {
                    tvColor.text = "Enter a color!"
                }
                etPetWeight.text.toString().isEmpty() -> {
                    etPetWeight.error = "Enter weight!"
                }
                else -> {
                    etPetName.error = null
                    etPetWeight.error = null
                    name = etPetName.text.toString()
                    color = chosenColor
                    weight = etPetWeight.text.toString().toLong()

                    if(cbVaccinated.isChecked){
                        condition += "Vaccinated"
                    }
                    if(cbWorm.isChecked){
                        condition += " Worm treatment"
                    }
                    if(cbMicrochipped.isChecked){
                        condition += " Microchipped"
                    }
                    if(swBabies.isChecked){
                        hasBabies = true
                    }
                    if(!swBabies.isChecked){
                        hasBabies = false
                    }

                    when(rgGender.checkedRadioButtonId){
                        R.id.rbMale -> gender = "Male"
                        R.id.rbFemale -> gender = "Female"
                    }

                    when(rgBreed.checkedRadioButtonId){
                        R.id.rbDog -> breed = "Dog"
                        R.id.rbCat -> breed = "Cat"
                    }

                    var intent = Intent(this, PetDetailActivity::class.java )
                    intent.putExtra("Name", name)
                    intent.putExtra("Color", color)
                    intent.putExtra("Weight", weight)
                    intent.putExtra("Birthdate", birthDate)
                    intent.putExtra("Gender", gender)
                    intent.putExtra("Breed", breed)
                    intent.putExtra("HasBabies", hasBabies)
                    intent.putExtra("Condition", condition)
                    startActivity(intent)

                }
            }
        }
    }
}