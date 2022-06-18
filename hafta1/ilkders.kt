//Bu yapı ile get,set,constructor otomatik oluşturulur.
data class Island(var name: String)

//view binding ve data binding ile işlemlerimizi yürütüyoruz.

fun main(args: Array<String>) {
    val island = Island("Bali")
    println(island.name)
    island.name = "Bali2"
    println(island.name)
}