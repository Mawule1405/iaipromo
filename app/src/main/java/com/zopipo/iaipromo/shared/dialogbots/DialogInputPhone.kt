package com.zopipo.iaipromo.shared.dialogbots

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.zopipo.iaipromo.R

class DialogInputPhone(private val context: Context,
                       private val title: String,
                       private val message: String,
                       private val positiveButtonAction: (number : String) -> Unit,
                       private val negativeButtonAction: () -> Unit)
{

    fun showDialog() {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_input_phone, null)
        builder.setView(dialogView)

        val titleTextView = dialogView.findViewById<TextView>(R.id.dialogBotTitle)
        val messageTextView = dialogView.findViewById<TextView>(R.id.dialogBotMessage)
        val numberFiel = dialogView.findViewById<EditText>(R.id.phoneNumberField)
        val validButton = dialogView.findViewById<Button>(R.id.validButton)
        val cancelButton = dialogView.findViewById<Button>(R.id.cancelButton)

        titleTextView.text = title
        messageTextView.text = message

        val dialog = builder.create()

        validButton.setOnClickListener {
            val number = numberFiel.text.toString()
            positiveButtonAction(number)
            dialog.dismiss()
        }

        cancelButton.setOnClickListener {
            negativeButtonAction()
            dialog.dismiss()
        }

        dialog.show()
    }
}