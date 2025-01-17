package com.zopipo.iaipromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zopipo.iaipromo.activities.ConnectActivity
import com.zopipo.iaipromo.activities.LoginActivity
import com.zopipo.iaipromo.models.checked.UserVerification
import com.zopipo.iaipromo.shared.dialogbots.DialogBotOk
import com.zopipo.iaipromo.shared.gadgets.NetworkUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            val checked = UserVerification().checkedOnCached()
            val network = NetworkUtils(this).isDeviceConnected()

            if(!network){
                if(!checked){
                    Intent(this, ConnectActivity::class.java).also {
                        startActivity(it)
                    }
                }else{
                    Intent(this, LoginActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }else{
                val dialog = DialogBotOk(context = this,
                    title = "Connexion internet",
                    message = "Vous êtes hors connexion. Veuillez vous connecter pour continuer.")
                dialog.showDialog()
            }

        }
    }
}