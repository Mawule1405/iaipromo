package com.zopipo.iaipromo.shared.gadgets

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import android.widget.ImageView
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView

class Animation() {


    fun rotateAnimation( view: View) {
        // Crée une animation de rotation continue
        val rotateAnim = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f)
        rotateAnim.duration = 2000 // Durée de la rotation (en millisecondes)
        rotateAnim.repeatCount = ObjectAnimator.INFINITE // Répéter l'animation indéfiniment
        rotateAnim.start() // Démarre l'animation
    }

    @SuppressLint("ObjectAnimatorBinding")
    fun translateAnimation(view: View){
        val translateAnim = ObjectAnimator.ofFloat(view, "translation", 0f, 100f)
        translateAnim.duration = 500
        translateAnim.repeatCount = ObjectAnimator.INFINITE
        translateAnim.start()
    }

    fun animateNumbers(textView: TextView, maxNumber: Int, delay: Long = 500L) {
        val handler = Handler(Looper.getMainLooper())
        var currentNumber = 0

        val runnable = object : Runnable {
            override fun run() {
                // Mise à jour du texte
                textView.text = "$currentNumber+"

                // Vérifier si le maximum est atteint
                if (currentNumber == maxNumber) {
                    // Réinitialiser après une pause de 5 secondes
                    handler.postDelayed(this, 5000L) // Pause de 5 secondes
                    currentNumber = 0
                } else {
                    // Continuer l'incrémentation normale
                    currentNumber++
                    handler.postDelayed(this, delay)
                }
            }
        }

        // Lancer l'animation
        handler.post(runnable)
    }


    fun animateTextSize(textView: TextView, minSize: Float, maxSize: Float, duration: Long = 1000L) {
        // Créer un ValueAnimator pour osciller entre minSize et maxSize
        val animator = ValueAnimator.ofFloat(minSize, maxSize).apply {
            this.duration = duration
            repeatMode = ValueAnimator.REVERSE // Alterner entre agrandissement et réduction
            repeatCount = ValueAnimator.INFINITE // Répéter indéfiniment

            addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Float
                textView.textSize = animatedValue // Mettre à jour la taille du texte
            }
        }

        animator.start()
    }


    fun animateTextContent(textView: TextView, strings: List<String>, delay: Long = 1000L) {
        val handler = Handler(Looper.getMainLooper())
        var currentIndex = 0

        val runnable = object : Runnable {
            override fun run() {
                // Met à jour le contenu du TextView
                textView.text = strings[currentIndex]

                // Passe à l'élément suivant (ou revient au début)
                currentIndex = (currentIndex + 1) % strings.size

                // Relance l'animation après le délai
                handler.postDelayed(this, delay)
            }
        }
        // Démarre l'animation
        handler.post(runnable)
    }


}
