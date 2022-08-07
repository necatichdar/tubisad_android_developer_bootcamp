package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity

import java.io.Serializable

data class YemekClass(
    var yemek_id: String,
    var yemek_adi: String,
    var yemek_resim_adi: String,
    var yemek_fiyat: String,
) : Serializable {
}