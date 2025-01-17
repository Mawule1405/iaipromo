package com.zopipo.iaipromo.shared.adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.activities.PromotionMembersActivity
import com.zopipo.iaipromo.models.models.Promotion
import com.zopipo.iaipromo.shared.Toasts
import kotlin.math.ceil


class PromotionAdapter(private val promotions: List<Promotion>) :
    RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.promotion_item, parent, false)
        return PromotionViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        val firstItemIndex = position * 2 // Position for the first item
        val secondItemIndex = firstItemIndex + 1 // Position for the second item

        // Bind first promotion
        if (firstItemIndex < promotions.size) {
            val firstPromotion = promotions[firstItemIndex]
            holder.bindFirstPromotion(firstPromotion)
        }

        // Bind second promotion (if exists)
        if (secondItemIndex < promotions.size) {
            val secondPromotion = promotions[secondItemIndex]
            holder.bindSecondPromotion(secondPromotion)
        } else {
            // Hide second promotion container
            holder.secondContainer.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        return ceil(promotions.size / 2.0).toInt() // Two items per row
    }

    class PromotionViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        val firstContainer: View = itemView.findViewById(R.id.promotion_item_1)
        val titlePromotion1: TextView = itemView.findViewById(R.id.titlePromotionTextView)
        val effectifPromotion1: TextView = itemView.findViewById(R.id.effectifPromotionTextView)
        val descriptionPromotion1: TextView = itemView.findViewById(R.id.descriptionPromotionTextView)
        val detailBtn1: Button = itemView.findViewById(R.id.promotionDetailBtn)

        internal val secondContainer: View = itemView.findViewById(R.id.promotion_item_2)
        val titlePromotion2: TextView = itemView.findViewById(R.id.titlePromotionTextView2)
        val effectifPromotion2: TextView = itemView.findViewById(R.id.effectifPromotionTextView2)
        val descriptionPromotion2: TextView = itemView.findViewById(R.id.descriptionPromotionTextView2)
        val detailBtn2: Button = itemView.findViewById(R.id.promotionDetailBtn2)

        fun bindFirstPromotion(promotion: Promotion) {
            titlePromotion1.text = promotion.titre
            effectifPromotion1.text = "${promotion.effectif} étudiants"
            descriptionPromotion1.text = promotion.description.slice(0 until 20)+" ..."
            detailBtn1.setOnClickListener {
                val toast = Toasts(context, promotion.titre)
                toast.successToast()
                val intent = Intent(context, PromotionMembersActivity::class.java)
                intent.putExtra("promotion_id", promotion.id) // passer l'ID de la promotion
                context.startActivity(intent)
            }
        }

        fun bindSecondPromotion(promotion: Promotion) {
            secondContainer.visibility = View.VISIBLE
            titlePromotion2.text = promotion.titre
            effectifPromotion2.text = "${promotion.effectif} étudiants"
            descriptionPromotion2.text = promotion.description.slice(0 until 20)+" ..."
            detailBtn2.setOnClickListener {
                val toast = Toasts(context, promotion.titre)
                toast.successToast()
                val intent = Intent(context, PromotionMembersActivity::class.java)
                intent.putExtra("promotion_id", promotion.id) // passer l'ID de la promotion
                context.startActivity(intent)
            }
        }
    }


}

