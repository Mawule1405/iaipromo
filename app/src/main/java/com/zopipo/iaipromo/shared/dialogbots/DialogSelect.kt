package com.zopipo.iaipromo.shared.dialogbots

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.models.models.Nationalite
import com.zopipo.iaipromo.models.models.Promotion

class DialogSelect {

    private var promotion : Promotion? = null
    private var nationalite : Nationalite? = null
    private var ressource : String? = null

     fun showPromotionSelectionDialog(context: Context, layout : LayoutInflater,textV : TextView, promotions : List<Promotion>) {


        val dialogView = layout.inflate(R.layout.dialog_select_promotion, null)
        val builder = AlertDialog.Builder(context).apply {
            setView(dialogView)
        }

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        val promotionListView = dialogView.findViewById<ListView>(R.id.listPromotionLv)
        var list = mutableListOf<String>()

         for(i in 0..promotions.size-1){
             list.add(promotions.get(i).titre)
         }

        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, list)
        promotionListView.adapter = adapter

        val dialog = builder.create()

        promotionListView.setOnItemClickListener { _, _, which, _  ->

            promotion = promotions[which]
            textV.text = promotion?.titre
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showNationaliteSelectionDialog(context: Context, layout : LayoutInflater,textV : TextView,  nationalites : List<Nationalite>) {


        val dialogView = layout.inflate(R.layout.dialog_select_nationalite, null)
        val builder = AlertDialog.Builder(context).apply {
            setView(dialogView)
        }

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        val paysListView = dialogView.findViewById<ListView>(R.id.listPaysLv)
        val list = mutableListOf<String>()

        for(i in 0..nationalites.size-1){
            list.add(nationalites.get(i).libelle)
        }

        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, list)
        paysListView.adapter = adapter

        val dialog = builder.create()

        paysListView.setOnItemClickListener { _, _, which, _  ->

            nationalite = nationalites[which]
            textV.text = nationalite?.libelle
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showRessourceSelectionDialog(context: Context, layout : LayoutInflater,  ressources : List<String>,
                                     actionCamera : ()->Unit,
                                     actionGallery : ()->Unit,
                                     defaultAction : () -> Unit
                                     ) {


        val dialogView = layout.inflate(R.layout.dialog_select_photo, null)
        val builder = AlertDialog.Builder(context).apply {
            setView(dialogView)
        }

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        val resListView = dialogView.findViewById<ListView>(R.id.listRessourceLv)

        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, ressources)
        resListView.adapter = adapter



        val dialog = builder.create()

        resListView.setOnItemClickListener { _, _, which, _  ->

            ressource = ressources[which]

            if(ressource.equals("Caméra")){
                actionCamera()
            }else if(ressource.equals("Gallerie")){
                actionGallery()
            }else{
                defaultAction()
            }

            dialog.dismiss()
        }
        dialog.show()
    }

    fun getPromotion() : Promotion? { return promotion}
    fun getNationalite(): Nationalite? {return  nationalite}
    fun getRessource(): String? { return  ressource}
    fun setPromotion(promotion : Promotion?){ this.promotion = promotion}
    fun setNationalite(nationalite : Nationalite?){this.nationalite = nationalite}
    fun setRessource(res : String?){ this.ressource = res}

}