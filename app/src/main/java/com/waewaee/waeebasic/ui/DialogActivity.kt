package com.waewaee.waeebasic.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.SnackbarContentLayout
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class DialogActivity : AppCompatActivity() {
    var KList = arrayOf("Kourt", "Kim", "Khloe", "Rob", "Kendall", "Kylie", "Mason", "Penelope", "Reign", "North", "Chicago", "Saint", "Palsm", "True", "Dream", "Stormi", "Lu pyoe g", "Broski", "Mdy thar g", "Heeeee")
    var chosenName = arrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        btnListDialog.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Choose your fav Kardashian!")
//            builder.setSingleChoiceItems(KList, -1){ dialog, position ->
//                Toast.makeText(this, "You chose ${KList[position]}", Toast.LENGTH_SHORT).show()
//                chosenName = KList[position]
//            }
            builder.setMultiChoiceItems(KList, null) { dialog, position, isChecked ->
                chosenName[position] = isChecked
                Toast.makeText(this, "You checked ${KList[position]}", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("Choose") { dialog, _ ->
                var temp = "Your chosen names are: "
                for (index in chosenName.indices) {
                    if (chosenName[index]) {
                        temp += " ${KList[index]}"
                    }
                }
                Toast.makeText(this, temp, Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            builder.show()
        }

        btnCustomAlertDialog.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("Fav Person")
            var layout = layoutInflater.inflate(R.layout.custom_dialog, null)
            alertDialog.setView(layout)
//            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK"){_,_ ->
//                Snackbar.make(parentLayout, "Your fav person is: ${layout.etName.text.toString()}",Snackbar.LENGTH_LONG).show()
//            }

            layout.btnSubmit.setOnClickListener {
                Snackbar.make(parentLayout, "Your fav person is: ${layout.etName.text.toString()}", Snackbar.LENGTH_LONG).show()
                alertDialog.dismiss()
            }
            alertDialog.show()
        }

        btnCustomDialog.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setTitle("Favorite Person")
            dialog.setCancelable(false)
            var layout = layoutInflater.inflate(R.layout.custom_dialog, null)
            dialog.setContentView(layout)
            dialog.window!!.setLayout(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layout.btnSubmit.setOnClickListener {
                Snackbar.make(parentLayout, "Your fav person is: ${layout.etName.text.toString()}", Snackbar.LENGTH_LONG).show()
                dialog.dismiss()
            }
            dialog.show()
        }

        btnDialogFragment.setOnClickListener {
            var fragment = EnterNameDialogFragment.newInstance("Waee's Pet")
            fragment.show(supportFragmentManager, "EnterName")
        }

        btnAlertDialogFragment.setOnClickListener {
            var alertDialogFragment = EnterNameAlertDialogFragment.newInstance("Waee's Pet")
            alertDialogFragment.show(supportFragmentManager, "EnterName")
        }
    }
}
