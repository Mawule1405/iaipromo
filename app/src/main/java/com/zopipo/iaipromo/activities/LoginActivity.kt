package com.zopipo.iaipromo.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.services.LoginService
import com.zopipo.iaipromo.shared.Toasts
import com.zopipo.iaipromo.shared.dialogbots.DialogBotOk
import com.zopipo.iaipromo.shared.dialogbots.DialogInputPhone

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginService =  LoginService()
        
        val passwordEt = findViewById<EditText>(R.id.passwordEt)
        val identifiantEt = findViewById<EditText>(R.id.identifiantEt)
        val apercuPasswordCb = findViewById<CheckBox>(R.id.apercuPasswordCb)
        val loginAccountBtn = findViewById<Button>(R.id.loginAccountBtn)
        val createAccountBtn = findViewById<Button>(R.id.createAccountBtn)
        val passwordForgetBtn = findViewById<Button>(R.id.passwordForgetBtn)
        val couvertureIv = findViewById<ImageView>(R.id.imageView)

        apercuPasswordCb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                passwordEt.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                passwordEt.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            passwordEt.setSelection(passwordEt.text.length)
        }

        loginAccountBtn.setOnClickListener{
            val identifiant = identifiantEt.text.toString()
            val password = passwordEt.text.toString()



            val member = loginService.getMember(identifiant, password)
            if(member !==null){

                val intent = Intent(this, ConnectActivity::class.java)
                intent.putExtra("memberId", member.id)
                this.startActivity(intent)

            }else{
                val dialog = DialogBotOk(context = this, title="Connexion",
                    message="Identifiant ou Mot de passe incorrect. Veuillez vérifier!")
                dialog.showDialog()
            }


        }

        createAccountBtn.setOnClickListener{
            Intent(this, AccountActivity::class.java).also {
                startActivity(it)
            }
        }

        passwordForgetBtn.setOnClickListener{

            Intent(this, ChangePasswordActivity::class.java).also{
                val dialog = DialogInputPhone(
                    context = this,
                    title = "Réinitialisation du mot de passe",
                    message = "Veuillez entrer un numéro WhatsApp de récupération",
                    positiveButtonAction = { number: String ->
                        // Vérification du format du numéro (facultatif)
                        if (number.isNotEmpty() && number.length >= 8) {
                            // Générer un code à six chiffres
                            val verificationCode = (100000..999999).random()

                            // Créer le message pour WhatsApp
                            val message = "Votre code de réinitialisation est : $verificationCode"

                            // Ouvrir WhatsApp pour envoyer le message
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("https://wa.me/$number?text=${Uri.encode(message)}")
                                Log.d("WhatsAppURI", "URI générée : $data")
                            }
                            try {
                                startActivity(intent)
                            } catch (e: Exception) {
                                val toast = Toasts(this, "Whatsapp n'est pas installé")
                                toast.errorToast()
                            }

                            // Envoyer le numéro et le code vers l'activité suivante
                            val nextActivityIntent = Intent(this, ChangePasswordActivity::class.java).apply {
                                putExtra("PHONE_NUMBER", number)
                                putExtra("VERIFICATION_CODE", verificationCode)
                            }
                            startActivity(nextActivityIntent)
                        } else {
                            val toast = Toasts(this, "Numéro incorrecte")
                            toast.errorToast()
                        }
                    },
                    negativeButtonAction = {
                        val toast = Toasts(this, "Réinitialisation du mot de passe est annulé")
                        toast.errorToast()
                    }
                )
                dialog.showDialog()


            }
        }
    }
}