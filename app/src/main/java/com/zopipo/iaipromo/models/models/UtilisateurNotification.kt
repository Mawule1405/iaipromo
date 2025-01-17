package com.zopipo.iaipromo.models.models

import java.time.LocalDateTime

data class UtilisateurNotification(var id:Int,
    var instant : LocalDateTime,
    var isReading : Boolean,
    var notification : Notification
    ){}
