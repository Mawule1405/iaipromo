package com.zopipo.iaipromo.services

import com.zopipo.iaipromo.models.models.Promotion

class PromotionService {

    fun getAllPromotion(): List<Promotion>{
        return mutableListOf(
        Promotion(1, "Promotion ING3 2022", false, 25, "Promotion des démons du code"),
        Promotion(2, "Promotion ING3 2023", false, 35, "Promotion des ..........."),
        Promotion(3, "Promotion ING3 2024", false, 20, "Promotion des démons du code"),
        Promotion(4, "Promotion ING3 2025", false, 12, "Promotion des ..........."),
        )
    }
}