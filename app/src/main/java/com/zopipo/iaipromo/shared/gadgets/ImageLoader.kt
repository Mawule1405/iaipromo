package com.zopipo.iaipromo.shared.gadgets

import android.animation.ObjectAnimator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import android.widget.ImageView
import android.content.Context

class ImageLoader(private val context: Context) {

    fun loadCircularImage(imageView: ImageView, imageResourceId: Int) {
        Glide.with(context)
            .load(imageResourceId)  // Charge l'image depuis les ressources
            .transform(CircleCrop()) // Applique la transformation circulaire
            .into(imageView)         // Applique l'image transformée à l'ImageView
    }

    fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
        Glide.with(context)
            .load(imageUrl)  // Charge l'image depuis l'URL
            .into(imageView)  // Applique l'image à l'ImageView
    }

    fun loadImageWithPlaceholder(imageView: ImageView, imageUrl: String, placeholder: Int) {
        Glide.with(context)
            .load(imageUrl)  // Charge l'image depuis l'URL
            .placeholder(placeholder)  // Utilise une image de remplacement pendant le chargement
            .into(imageView)  // Applique l'image à l'ImageView
    }

    fun loadImageWithPlaceholder(imageView: ImageView, imageUrl: Int, placeholder: Int) {
        Glide.with(context)
            .load(imageUrl)  // Charge l'image depuis l'URL
            .placeholder(placeholder)  // Utilise une image de remplacement pendant le chargement
            .into(imageView)  // Applique l'image à l'ImageView
    }

    fun rotateImage(imageView: ImageView) {
        // Crée une animation de rotation continue
        val rotateAnim = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f)
        rotateAnim.duration = 2000 // Durée de la rotation (en millisecondes)
        rotateAnim.repeatCount = ObjectAnimator.INFINITE // Répéter l'animation indéfiniment
        rotateAnim.start() // Démarre l'animation
    }
}
