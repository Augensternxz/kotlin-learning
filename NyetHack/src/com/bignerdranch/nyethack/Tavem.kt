import kotlin.math.roundToInt
import java.io.File
import java.io.PrintStream
import com.bignerdranch.nyethack.extensions.random

const val TAVERN_NAME = "Taernyl's Folly"

/*var playerGold = 10
var playerSilver = 10*/
//val patronList = listOf("Eli", "Mordoc", "Sophie")
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("NyetHack/data/tavern-menu-items")
    .readText()
    .split("\r\n")
//val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val patronGold = mutableMapOf<String, Double>()

//private fun <T> Iterable<T>.random() : T = this.shuffled().first()

fun main() {
/*//    val beverage = readLine() ?.replaceFirstChar { it.uppercase() }
//    var beverage = readLine()?.capitalize()

    *//*var beverage = readLine() ?. let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    }*//*
//    var beverage = readLine() !!. capitalize()
//    beverage = null
    var beverage = readLine()
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null")
    }

//    println(beverage)
    var beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
*//*var signatureDrink = "Buttered Ale"
    赋值为null会报错的
    signatureDrink = null*/
//    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder("elixir, Shirley's Temple,4.12")
//    println(patronList[0])
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    /*println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0, "Alex")
    patronList[0] = "Alexis"
    println(patronList)*/

    /*for (patron in patronList) {
        println("Good evening, $patron")
    }*/
    /*patronList.forEach { patron ->
        println("Good evening, $patron")
    }*/
    /*patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line")
//        placeOrder(patron, "shandy,Dragon's Breath, 5.91")
        placeOrder(patron, menuList.shuffled().first())
    }

    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }*/
    (0..9).forEach {
        val first = patronList.random()/*.shuffled().first()*/
        val last = lastName.random()/*.shuffled().first()*/
        val name = "$first $last"
//        println(name)
        uniquePatrons += name
    }
//    println(uniquePatrons)
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.random()/*.shuffled().first()*/,
            menuList.random()/*.shuffled().first()*/)
        orderCount++
    }
//    println(patronGold)

}

/*fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    var remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}*/

private fun displayBalance() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")

    }
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
/*
深入学习改动
private String.replaceDragonSpeak = this.replace.........
* */


private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
//    println("Madrigal speaks with $tavernMaster about their order.")
    println("$patronName speaks with $tavernMaster about their order.")

    /*val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]*/
    val (type, name, price) = menuData.split(',')
//    val message = "Madrigal buys a $name ($type) for $price."
    val message = "$patronName buys a $name ($type) for $price."

    println(message)

    performPurchase(price.toDouble(), patronName)
    /*val phrase = "Ah, delicious $name!"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")*/

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"

    } else {
//        "Madrigal says: Thanks for the $name"
        "$patronName says: Thanks for the $name"

    }
    println(phrase)
}