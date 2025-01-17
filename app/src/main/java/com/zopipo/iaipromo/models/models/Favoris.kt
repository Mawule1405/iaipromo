package com.zopipo.iaipromo.models.models

import java.time.LocalDateTime

data class Favoris(var id:Int,
    var instant : LocalDateTime,
    var isDelete : Boolean,
    var utilisateur : Utilisateur
    ){}
