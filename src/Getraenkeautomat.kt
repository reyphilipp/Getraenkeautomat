/**
 * Created by admin on 04.12.2017.
 */
data class Getraenk(val getraenk: String, val preis: Double)
val getraenkeliste = arrayListOf<Getraenk>(Getraenk("Wasser", 0.5),Getraenk("Limonade", 1.0),Getraenk("Bier", 2.0))

fun main(args: Array<String>) {
    startBildschirm()
    println(bezahlen(auswahl()))

}

fun startBildschirm() {
    println("Wähle ein Getränk:\n")
    for (i in getraenkeliste.indices)
    println(i.toString() + ")${getraenkeliste[i].getraenk}(%.2f".format(getraenkeliste[i].preis)+" CHF)")
}

fun auswahl(): Int{
    println("Wählen sie zwischen "+getraenkeliste.indices+" aus!")
    val input = readLine()
    try{
        if (input != null) {
            return input.toInt()
        }
    } catch (e: Exception){
        println(e)
    }
    return 99
}

fun bezahlen(auswahl: Int):Double{
    println("Wirf"+getraenkeliste[auswahl].preis+" CHF ein")
    val input = readLine()
    try{
        if (input != null) {
            input + 0
        }
    } catch (e: Exception){
        println(e)
    }
    return 99.0
}