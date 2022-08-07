package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity

import java.io.Serializable

data class YaziClass(
    var yazi_id: Int,
    var yazi_title: String,
    var yazi_description: String,
    var yazi_image: String
) : Serializable {
}
