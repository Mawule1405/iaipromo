package com.zopipo.iaipromo.activities.ui.compte

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zopipo.iaipromo.models.models.Nationalite
import com.zopipo.iaipromo.models.models.Promotion
import com.zopipo.iaipromo.models.models.Role
import com.zopipo.iaipromo.models.models.Utilisateur

class CompteViewModel : ViewModel() {

    val compte = Utilisateur(
        id = 3,
        nom = "HELOU",
        prenom = "Komlan Mawulé",
        email = "heloumawule@gmail.com",
        photo = "mawule",
        phoneNumber = "24174630473",
        cv = "CV Path",
        isDelete = false,
        isLogin = true,
        isActive = true,
        nationalite = Nationalite(1,"+228", "Togolais", false),
        roles = mutableListOf(Role(1,"Admin", false)),
        contacts = mutableListOf(),
        avis = mutableListOf(),
        signals = mutableListOf(),
        promotions = mutableListOf(
            Promotion(1, "Promotion ING3 2022", false, 25, "Promotion des démons du code"),
            Promotion(2, "Promotion ING3 2023", false, 35, "Promotion des ..........."),
            ),
        aides = mutableListOf(),
        favoris = mutableListOf(),
        utilisateurNotification = mutableListOf()
    )


}