import kotlin.system.exitProcess

data class Getraenk(val getraenk: String, val preis: Double)

val getraenkeliste = arrayListOf<Getraenk>(Getraenk("Wasser", 0.5), Getraenk("Limonade", 1.0), Getraenk("Bier", 2.0))
var auswahl = 0


fun main(args: Array<String>) {

    startBildschirm()
    auswahl = auswaehlen()
    rechnen()
}

fun startBildschirm() {
    println("Wähle ein Getränk:\n")
    for (i in getraenkeliste.indices)
        println(i.toString() + ")${getraenkeliste[i].getraenk}(%.2f".format(getraenkeliste[i].preis) + " CHF)")
}

fun auswaehlen(): Int {
    println("Wählen sie zwischen " + getraenkeliste.indices + " aus!")
    val input = readLine()
    try {
        if (input != null) {
            return input.toInt()
        }
    } catch (e: Exception) {
        println(e)
        exitProcess(0)
    }
    return 99
}

fun aufforderungBezahlen(Betrag: Double) {
    println("Wirf %.2f".format(Betrag) + " CHF ein")
}

fun muenzEinwurf(): Double {
    val input = readLine()
    try {
        if (input != null) {
            return input.toDouble()
        }
    } catch (e: Exception) {
        println(e)
        exitProcess(0)
    }
    return 99.0
}

fun rechnen() {
    var istBetrag = 0.0
    var sollBetrag = (getraenkeliste[auswahl].preis)
    aufforderungBezahlen(sollBetrag)
    istBetrag = muenzEinwurf()

    while (istBetrag < sollBetrag) {
        aufforderungBezahlen(rundeBetrag(sollBetrag - istBetrag))
        sollBetrag = sollBetrag - istBetrag
        istBetrag = muenzEinwurf()
    }
    if (istBetrag == sollBetrag) {
        getraenkeAsugabe()
    }
    if (istBetrag > sollBetrag) {
        getraenkeAsugabe()
        rueckgeld(istBetrag, sollBetrag)
    }
}

fun rueckgeld(istBetrag: Double, sollBetrag: Double) {
    println("%.2f".format(istBetrag - sollBetrag) + " CHF Rückgeld wird ausgegeben")
}

fun rundeBetrag(betrag: Double): Double {
    return Math.round(betrag * 100.0) / 100.0
}

fun getraenkeAsugabe() {
    println("Getränk " + getraenkeliste[auswahl].getraenk + " wird ausgegeben")
}