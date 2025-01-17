package com.zopipo.iaipromo.services

import com.zopipo.iaipromo.models.models.Nationalite

class NationaliteService {

    fun getAllNationalites() : List<Nationalite>{
        return mutableListOf(
            Nationalite(1, "229", "Bénin", false),
            Nationalite(2, "224", "Burkina Faso", false),
            Nationalite(3, "237", "Caméroun", false),
            Nationalite(4, "225", "Côte d'Ivoire", false),
            Nationalite(5, "243", "Congo", false),
            Nationalite(6, "241", "Gabon", false),
            Nationalite(7, "240", "R Centrafrique", false),
            Nationalite(8, "227", "Niger", false),
            Nationalite(9, "221", "Sénégal", false),
            Nationalite(10, "235", "Tchad", false),
            Nationalite(11, "228", "Togo", false)
        )
    }
}