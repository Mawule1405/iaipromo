package com.zopipo.iaipromo.activities.ui.Favoris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zopipo.iaipromo.models.models.Nationalite
import com.zopipo.iaipromo.models.models.Role
import com.zopipo.iaipromo.models.models.Utilisateur

class FavorisViewModel : ViewModel() {

    val utilisateurs2 = arrayListOf(
        Utilisateur(
            id = 1,
            nom = "Dupont",
            prenom = "Jean",
            email = "jean.dupont@example.com",
            photo = "logo_iaipromo",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        ),
        Utilisateur(
            id =  2,
            nom = "Dupont",
            prenom = "Robert",
            email = "robert.dupont@example.com",
            photo = "logo_iaipromo",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        ),
        Utilisateur(
            id = 3,
            nom = "HELOU",
            prenom = "Komlan Mawulé",
            email = "heloumawule@gmail.com",
            photo = "image_couverture",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        )

        ,

        Utilisateur(
            id = 4,
            nom = "HELOU",
            prenom = "Komlan Mawulé",
            email = "heloumawule@gmail.com",
            photo = "image_couverture",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        )
        ,

        Utilisateur(
            id = 4,
            nom = "HELOU",
            prenom = "Komlan Mawulé",
            email = "heloumawule@gmail.com",
            photo = "logo_iaipromo",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        )
        ,

        Utilisateur(
            id = 4,
            nom = "HELOU",
            prenom = "Komlan Mawulé",
            email = "heloumawule@gmail.com",
            photo = "image_couverture",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        )
        ,

        Utilisateur(
            id = 4,
            nom = "HELOU",
            prenom = "Komlan Mawulé",
            email = "heloumawule@gmail.com",
            photo = "logo_svg",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"+228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        )
        ,

        Utilisateur(
            id = 4,
            nom = "HELOU",
            prenom = "Komlan Mawulé",
            email = "heloumawule@gmail.com",
            photo = "image_couverture",
            cv = "CV Path",
            phoneNumber = "24174630473",
            isDelete = false,
            isLogin = true,
            isActive = true,
            nationalite = Nationalite(1,"228", "Togolais", false),
            roles = mutableListOf(Role(1,"Admin", false)),
            contacts = mutableListOf(),
            avis = mutableListOf(),
            signals = mutableListOf(),
            promotions = mutableListOf(),
            aides = mutableListOf(),
            favoris = mutableListOf(),
            utilisateurNotification = mutableListOf()
        )



    )
}