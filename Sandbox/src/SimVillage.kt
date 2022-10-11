import com.sun.media.jfxmedia.events.PlayerEvent

fun main() {

    runSimulation()
//    runSimulation("Guyal") { playerName, numBuildings ->
    /*runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2022
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName!(copyright $currentYear)"
    }*/
/*val greetingFunction = { playerName : String, numBuildings : Int ->
    }
    //println(greetingFunction("Guyal",2))
    runSimulation("Guyal", greetingFunction)*/
/*val greetingFunction:(String, Int) -> String = { playerName, numBuildings ->
    }
    println(greetingFunction("Guyal",2))*/
/*val greetingFunction:(String) -> String = {
        val currentYear = 2022
        "Welcome to SimVillage, $it!(copyright $currentYear)"
    }
    println(greetingFunction("Guyal"))*/
/*val greetingFunction:(String) -> String = { playerName ->
        val currentYear = 2022
        "Welcome to SimVillage, $playerName!(copyright $currentYear)"
    }
    println(greetingFunction("Guyal"))*/
/*val greetingFunction:() -> String = {

    }*/
/*println({
        val currentYear = 2022
        "Welcome to SimVillage, Mayor!(copyright $currentYear)"
    }())*/
}

//inline fun runSimulation(playerName : String, greetingFunction : (String, Int) -> String) {
/*inline fun runSimulation(playerName : String,
                         costPrinter : (Int) -> Unit,
                         greetingFunction : (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last() //随机选择123
    costPrinter(numBuildings)
    print(greetingFunction(playerName,numBuildings))
}*/
fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    print(greetingFunction("Guyal"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2022
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}

fun printConstructionCost(numBuildings : Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}