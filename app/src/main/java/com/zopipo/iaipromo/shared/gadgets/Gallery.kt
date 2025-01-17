package com.zopipo.iaipromo.shared.gadgets

import android.app.Activity
import android.content.Intent
import android.widget.ImageView

class Gallery : Activity() {

    fun openGalleryForImage(resultLoadImage : Int){
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, resultLoadImage)
    }
}