package com.waewaee.waeebasic.ui

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.dialog_fragment_enter_name.*

class EnterNameDialogFragment: DialogFragment() {
    companion object{
        fun newInstance(title:String):EnterNameDialogFragment{
            var fragment = EnterNameDialogFragment()
            var argument = Bundle()
            argument.putString("Waee", title)
            fragment.arguments = argument
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_enter_name, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setWidthPercent(85, 50)
        tvTitle.text = requireArguments().getString("Waee")
        btnOkay.setOnClickListener {
            var petName = etPetName.text.toString()
            if(petName.isEmpty()){
                tilName.error = "Enter your pet name!"
            }else{
                tilName.error = ""
            }
            Toast.makeText(context, petName, Toast.LENGTH_LONG).show()
            dismiss()
        }
    }

    private fun setWidthPercent(width: Int,height:Int) {
        val widthPercent = width.toFloat() / 100
        val heightPercent = height.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = rect.width() * widthPercent
        val percentHeight = rect.height() * heightPercent
        dialog?.window?.setLayout(percentWidth.toInt(), percentHeight.toInt())
    }

    fun setFullScreen() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}