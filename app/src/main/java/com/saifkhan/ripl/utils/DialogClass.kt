package com.saifkhan.ripl.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.saifkhan.ripl.R

class DialogClass {

    companion object {
//        fun loadingDialog(context: Context): Dialog {
//            val dialog = Dialog(context)
//            dialog.setContentView(R.layout.dialog_layout_loading)
//            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            dialog.setCancelable(false)
//            return dialog
//        }

//        fun errorDialog(context: Context, errorMessage: String) {
//            val dialog = Dialog(context)
//            dialog.setContentView(R.layout.dialog_layout_error)
//
//
//            // set the custom dialog components - text, image and button
//            val titleText = dialog.findViewById<TextView>(R.id.tv_title_text)
////            titleText.text = context.getString(R.string.ops_error)
//
//            val errorTextMessage = dialog.findViewById<TextView>(R.id.tv_error_message)
//            errorTextMessage.setText(errorMessage)
//
//            val dialogButton = dialog.findViewById<Button>(R.id.btn_dialog_okay)
////        // if button is clicked, close the custom dialog
//            dialogButton.setOnClickListener { v: View? -> dialog.dismiss() }
//            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            dialog.show()
//        }

//        fun homeTownDialog(context: Context): Dialog {
//            val dialog = Dialog(context)
//            dialog.setContentView(R.layout.dialog_layout_home_town)
//            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            dialog.setCancelable(true)
//            return dialog
//        }

        fun filterListDialog(context: Context): Dialog {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_filter)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(true)
            return dialog
        }
    }



}