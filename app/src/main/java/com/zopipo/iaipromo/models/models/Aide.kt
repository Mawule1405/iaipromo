package com.zopipo.iaipromo.models.models

import java.time.LocalDateTime

data class Aide(var id : Int,
    var titre : String,
    var contenu : String,
    var instant : LocalDateTime
    ){}
