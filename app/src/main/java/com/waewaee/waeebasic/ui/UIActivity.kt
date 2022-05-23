package com.waewaee.waeebasic.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_u_i.*

class UIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i)
        rgKFamily.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.rdKourt -> Snackbar.make(layout, "Likes Kourt", Snackbar.LENGTH_LONG).show()
                R.id.rdKim -> Snackbar.make(layout, "Likes Kim", Snackbar.LENGTH_LONG).show()
                R.id.rdKhloe -> Snackbar.make(layout, "Likes Khloe", Snackbar.LENGTH_LONG).show()
                R.id.rdRob -> Snackbar.make(layout, "Likes Robert", Snackbar.LENGTH_LONG).show()
                R.id.rdKen -> Snackbar.make(layout, "Likes Kendall", Snackbar.LENGTH_LONG).show()
                R.id.rdKylie -> Snackbar.make(layout, "Likes Kylie", Snackbar.LENGTH_LONG).show()
            }
        }
        btnCheck.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Wae Waee").setMessage("Are you sure to continue?")
            builder.setCancelable(false)
            builder.setIcon(R.drawable.ic_song)
//            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, _ ->
//                dialog.dismiss()
//                setUpAction()
//            })
//            builder.setNegativeButton("Nooo", DialogInterface.OnClickListener { dialog, _ ->
//                dialog.dismiss()
//            })

            val dialog = builder.create()
            dialog.setTitle("Jiptoo")
            dialog.setMessage("Thay Char lar?")
            dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "", getDrawable(R.drawable.ic_song)){_, _ ->
                Toast.makeText(this, "This is neutral button", Toast.LENGTH_LONG).show()
            }
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "", getDrawable(R.drawable.ic_yes)){_,_ ->
                setUpAction()
            }
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "", getDrawable(R.drawable.ic_no)){_,_ ->

            }
            dialog.show()

        }

    }

    private fun setUpAction(){
        if(etGreetings.text.toString() == ""){
            etGreetings.error = "Enter Greetings!"
        }
        else {
            etGreetings.error = null
            var temp = ""
            if(cbJipToo.isChecked){
                temp += "JipToo "

            }

            if(cbWaeee.isChecked){
                temp += "Waeee "
            }

            if(cbParPhaung.isChecked){
                temp += "Par Phaung "
            }

            if(tgButton.isChecked){
                temp += "Toggle is activited "
            }

            if(swThanakha.isChecked){
                temp += "Wearing Thanakha "
            }
            when(rgKFamily.checkedRadioButtonId){
                R.id.rdKourt -> temp += "Likes Kourtney "
                R.id.rdKim -> temp += "Likes Kim "
                R.id.rdKhloe -> temp += "Likes Khloe "
                R.id.rdRob -> temp += "Likes Robert "
                R.id.rdKen -> temp += "Likes Kendall "
                R.id.rdKylie -> temp += "Likes Kylie "
            }
            temp += "says " + etGreetings.text
            Snackbar.make(layout, temp, Snackbar.LENGTH_LONG).show()
        }
    }
}