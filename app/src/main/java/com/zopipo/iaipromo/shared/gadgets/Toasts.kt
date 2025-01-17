package com.zopipo.iaipromo.shared

import android.content.Context
import android.widget.Toast
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.view.LayoutInflater
import com.zopipo.iaipromo.R

class Toasts(val context: Context, val text: String) {


    // Show an information toast
    fun informationToast() {
        showToast(text, R.drawable.toast_info)
    }

    // Show an error toast
    fun errorToast() {
        showToast(text, R.drawable.toast_error)
    }

    // Show a success toast
    fun successToast() {
        showToast(text, R.drawable.toast_success)
    }

    // Show a warning toast
    fun warningToast() {
        showToast(text, R.drawable.toast_warning)
    }

    // Helper method to create and display a toast with a specific color

    private fun showToast(message: String, color : Int) {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT

        val inflater = LayoutInflater.from(context)
        val layout: View = inflater.inflate(R.layout.custom_toast_layout, null)
        val textView: TextView = layout.findViewById(R.id.toast_text)

        textView.text = message
        layout.setBackgroundResource(color)

        toast.view = layout
        toast.setGravity(Gravity.BOTTOM, 0, 100)
        toast.show()
    }
}
