package com.zopipo.iaipromo.shared.dialogbots

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.zopipo.iaipromo.R


class DialogBotYesNo(
    private val context: Context,
    private val title: String,
    private val message: String,
    private val positiveButtonAction: () -> Unit,
    private val negativeButtonAction: () -> Unit
) {

    fun showDialog() {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_bot_yes_no, null)
        builder.setView(dialogView)

        val titleTextView = dialogView.findViewById<TextView>(R.id.dialogBotTitle)
        val messageTextView = dialogView.findViewById<TextView>(R.id.dialogBotMessage)
        val yesButton = dialogView.findViewById<Button>(R.id.yesButton)
        val noButton = dialogView.findViewById<Button>(R.id.noButton)

        titleTextView.text = title
        messageTextView.text = message

        val dialog = builder.create()

        yesButton.setOnClickListener {
            positiveButtonAction()
            dialog.dismiss()
        }

        noButton.setOnClickListener {
            negativeButtonAction()
            dialog.dismiss()
        }
        dialog.show()
    }
}
