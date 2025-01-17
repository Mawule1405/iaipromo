package com.zopipo.iaipromo.models.models

data class Promotion(
    var id: Int,
    var titre: String,
    var isDelete: Boolean,
    var effectif: Int,
    var description: String,
    var membres: ArrayList<Utilisateur> = arrayListOf()
)
