package com.zopipo.iaipromo.modeles.datas

import com.zopipo.iaipromo.models.models.Nationalite
import com.zopipo.iaipromo.models.models.Promotion
import com.zopipo.iaipromo.models.models.Role
import com.zopipo.iaipromo.models.models.Utilisateur


class TestData {

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
        promotions = mutableListOf(),
        aides = mutableListOf(),
        favoris = mutableListOf(),
        utilisateurNotification = mutableListOf()
    )

    val utilisateurs = arrayListOf(
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



    )

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

    val promotions = arrayListOf(
        Promotion(1, "Promotion ING3 2022", false, 25, "Promotion des démons du code", utilisateurs),
        Promotion(2, "Promotion ING3 2023", false, 35, "Promotion des ..........."),
        Promotion(3, "Promotion ING3 2024", false, 20, "Promotion des démons du code", utilisateurs2),
        Promotion(4, "Promotion ING3 2025", false, 12, "Promotion des ...........")
    )

    fun getPromotion(id: Int): Promotion? {
        return promotions.find { promotion -> promotion.id == id }
    }

}