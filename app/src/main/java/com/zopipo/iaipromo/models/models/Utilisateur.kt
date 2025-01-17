package com.zopipo.iaipromo.models.models

import com.zopipo.iaipromo.models.models.Nationalite

data class Utilisateur(
    var id:Int,
    var nom : String,
    var prenom : String,
    var email : String,
    var photo : String,
    var phoneNumber : String,
    var cv : String,
    var isDelete : Boolean,
    var isLogin : Boolean,
    var isActive : Boolean,
    var nationalite: Nationalite,
    var roles : MutableList<Role>,
    var contacts : MutableList<Contact>,
    var avis : MutableList<Avis>,
    var signals : MutableList<Signal>,
    var promotions : MutableList<Promotion>,
    var aides : MutableList<Aide>,
    var favoris : MutableList<Favoris>,
    var utilisateurNotification : MutableList<UtilisateurNotification>
){

}
