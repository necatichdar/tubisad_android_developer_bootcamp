package com.chdarsoft.odev6

import java.io.Serializable

data class Urunler(
    var urunId: Int,
    var urunAdi: String,
    var urunResim: String,
    var urunFiyat: Double,
    var urunEskiFiyat: Double,
) : Serializable {
}