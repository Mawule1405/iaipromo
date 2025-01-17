package com.zopipo.iaipromo.shared.adapters

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.activities.DetailMembreActivity
import com.zopipo.iaipromo.models.models.Utilisateur
import com.zopipo.iaipromo.shared.Toasts
import com.zopipo.iaipromo.shared.dialogbots.DialogBotYesNo
import com.zopipo.iaipromo.shared.gadgets.ImageLoader

class MembreFavorisAdapter(private val students: List<Utilisateur>) :
    RecyclerView.Adapter<MembreFavorisAdapter.MembreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_member_favoris, parent, false)
        return MembreViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: MembreViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class MembreViewHolder(itemView: View, val context : Context) : RecyclerView.ViewHolder(itemView) {
        private val studentImageView: ImageView = itemView.findViewById(R.id.studentImageView)
        private val studentNomTextView: TextView = itemView.findViewById(R.id.studentNomTextView)
        private val studentPrenomTextView: TextView = itemView.findViewById(R.id.studentPrenomTextView)
        private val telephoneTextView: TextView = itemView.findViewById(R.id.telephoneTextView)
        private val emailTextView : TextView = itemView.findViewById(R.id.emailTextView)
        private val detailImageView: ImageView = itemView.findViewById(R.id.detailImageView)
        private val signalerImageView: ImageView = itemView.findViewById(R.id.signalerImageView)
        private val mailImageView: ImageView = itemView.findViewById(R.id.mailImageView)
        private val whatsappImageView: ImageView = itemView.findViewById(R.id.whatsappImageView)

        fun bind(utilisateur : Utilisateur) {

            ImageLoader(context).loadCircularImage(studentImageView, R.drawable.image_couverture, R.drawable.defaut_member_image)
            studentNomTextView.text = utilisateur.nom
            studentPrenomTextView.text = utilisateur.prenom
            telephoneTextView.text = utilisateur.phoneNumber
            emailTextView.text = utilisateur.email

            // Ajoutez des actions de clic pour les ImageView si nécessaire
            detailImageView.setOnClickListener {
                // Action pour detailImageView
                val intent = Intent(context, DetailMembreActivity::class.java)
                intent.putExtra("membre_id" , utilisateur.id)
                context.startActivity(intent)
            }

            signalerImageView.setOnClickListener {
                val dialog = DialogBotYesNo(
                    context = context,
                    title ="Signalement",
                    message = "Êtes vous certains de vouloir signaler le compte de : ${utilisateur.nom} ${utilisateur.prenom}?",
                    positiveButtonAction = {},
                    negativeButtonAction = {}
                )
                dialog.showDialog()

            }

            mailImageView.setOnClickListener {
                val emailAddress = emailTextView.text.toString() // Adresse email du destinataire
                val subject = "" // Sujet de l'email
                val body = "" // Corps du message

                val uri = Uri.parse("mailto:")
                    .buildUpon()
                    .appendQueryParameter("to", emailAddress)
                    .appendQueryParameter("subject", subject)
                    .appendQueryParameter("body", body)
                    .build()

                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = uri
                }

                try {
                    context.startActivity(emailIntent) // Ouvrir l'application d'email
                } catch (e: ActivityNotFoundException) {
                    val toast = Toasts(context, "Aucune application d'email n'est installer sur votre téléphone")
                    toast.errorToast()
                }
            }


            whatsappImageView.setOnClickListener {
                val phoneNumber = telephoneTextView.text
                val message = ""

                val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}"
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(url)
                }

                try {
                    context.startActivity(intent) // Ouvrir WhatsApp
                } catch (e: ActivityNotFoundException) {
                    val toast = Toasts(context, "Whatsapp n'est pas installer sur votre téléphone")
                    toast.errorToast()
                }
            }

        }
    }
}
