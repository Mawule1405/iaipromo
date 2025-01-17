package com.zopipo.iaipromo.services

import com.zopipo.iaipromo.modeles.datas.TestData
import com.zopipo.iaipromo.models.models.Utilisateur

class LoginService {

    fun getMember(identifiant: String, password : String) : Utilisateur?{

        if(identifiant.equals("membre") && password.equals("membre")){
            val utilisateur = TestData().compte
            return utilisateur
        }else{
            return null
        }
    }

    fun setMember(utilisateur : Utilisateur){

    }
}