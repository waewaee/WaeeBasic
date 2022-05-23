package com.waewaee.waeebasic.ui

import android.app.AlertDialog
import android.app.Dialog
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
import kotlinx.android.synthetic.main.dialog_fragment_enter_name.view.*

class EnterNameAlertDialogFragment: DialogFragment() {
    companion object{
        fun newInstance(title:String):EnterNameAlertDialogFragment{
            var fragment = EnterNameAlertDialogFragment()
            var argument = Bundle()
            argument.putString("Waee", title)
            fragment.arguments = argument
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var title = requireArguments().getString("Waee")
        var dialog = AlertDialog.Builder(requireContext()).create()
        var layout = View.inflate(requireContext(), R.layout.dialog_fragment_enter_name, null)
        dialog.setView(layout)
        layout.tvTitle.text = title
        layout.btnOkay.setOnClickListener {
            var petName = layout.etPetName.text.toString()
            if(petName.isEmpty()){
                layout.tilName.error = "Enter your pet name!"
            }else{
                layout.tilName.error = ""
                Toast.makeText(context, petName, Toast.LENGTH_LONG).show()
                dismiss()
            }
        }
        return dialog
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        setWidthPercent(85, 50)
//        tvTitle.text = requireArguments().getString("Waee")
//        btnOkay.setOnClickListener {
//            var petName = etPetName.text.toString()
//            if(petName.isEmpty()){
//                tilName.error = "Enter your pet name!"
//            }else{
//                tilName.error = ""
//            }
//            Toast.makeText(context, petName, Toast.LENGTH_LONG).show()
//            dismiss()
//        }
//    }

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