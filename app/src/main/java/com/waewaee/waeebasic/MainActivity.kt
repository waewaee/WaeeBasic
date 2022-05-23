package com.waewaee.waeebasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("waee", "onCreate")
//

        btnShowToast.setOnClickListener {
            Toast.makeText(this, "Toast One", Toast.LENGTH_LONG).show()
            tvShow.text = "Toast One"
        }

        btnShowToastTwo.setOnClickListener {
            Toast.makeText(this, "Toast Two", Toast.LENGTH_LONG).show()
            tvShow.text = "Toast Two"

        }

        btnNext.setOnClickListener {
            var name = edName.text.toString()
            var phone = edPhone.text.toString()
            var age = try{
                edAge.text.toString().toInt()
            } catch (e:Exception){
                0
            }

            var email = edEmail.text.toString()

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Waee", "Waee is pretty")
            intent.putExtra("Name", name)
            intent.putExtra("Phone", phone)
            intent.putExtra("Age", age)
            intent.putExtra("Email", email)
            startActivity(intent)

        }


    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show()
        Log.e("waee", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show()
        Log.e("waee", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show()
        Log.e("waee", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show()
        Log.e("waee", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
        Log.e("waee", "onDestroy")

    }
}