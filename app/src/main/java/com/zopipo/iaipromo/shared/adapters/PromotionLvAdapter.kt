package com.zopipo.iaipromo.shared.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.models.models.Promotion

class PromotionLvAdapter(
    private val context: Context,
    private val promotions: List<Promotion>
) : BaseAdapter() {

    override fun getCount(): Int = promotions.size

    override fun getItem(position: Int): Any = promotions[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.promotion_lv, parent, false)

        // Récupérer les vues du layout
        val titlePromotionTv: TextView = view.findViewById(R.id.titlePromotionTv)
        val effectifPromotionTv: TextView = view.findViewById(R.id.effectifPromotionTv)

        // Récupérer l'élément actuel
        val promotion = getItem(position) as Promotion

        // Remplir les données
        titlePromotionTv.text = promotion.titre
        effectifPromotionTv.text = promotion.effectif.toString()

        return view
    }
}
