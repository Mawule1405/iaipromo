package com.zopipo.iaipromo.shared.dialogbots

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.zopipo.iaipromo.R


class DialogBotOk(
    private val context: Context,
    private val title: String,
    private val message: String,

) {

    fun showDialog() {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_bot_ok, null)
        builder.setView(dialogView)

        val titleTextView = dialogView.findViewById<TextView>(R.id.dialogBotOkTitle)
        val messageTextView = dialogView.findViewById<TextView>(R.id.dialogBotOkMessage)
        val okButton = dialogView.findViewById<Button>(R.id.okButton)

        titleTextView.text = title
        messageTextView.text = message

        val dialog = builder.create()

        okButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
