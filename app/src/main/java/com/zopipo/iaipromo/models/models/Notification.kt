package com.zopipo.iaipromo.models.models

import java.time.LocalDate

data class Notification(var id : Int,
    var titre : String,
    var description : String,
    var date : LocalDate
    ){}
