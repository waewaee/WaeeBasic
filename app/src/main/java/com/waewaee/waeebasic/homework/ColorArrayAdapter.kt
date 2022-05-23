package com.waewaee.waeebasic.homework

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.waewaee.waeebasic.R
import kotlinx.android.synthetic.main.activity_pet.*
import kotlinx.android.synthetic.main.spinner_color.view.*

class ColorArrayAdapter(var context: Context, var colorList: Array<String>, var colorIdList: Array<Int>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.spinner_color, parent, false)
        view.tvColor.text = colorList[position]
        view.ivColor.setBackgroundColor(ContextCompat.getColor(context, colorIdList[position]))
        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return colorList.size
    }
}