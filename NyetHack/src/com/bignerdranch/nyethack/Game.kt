import com.bignerdranch.nyethack.Direction
import com.bignerdranch.nyethack.Player
import com.bignerdranch.nyethack.Room
import com.bignerdranch.nyethack.TownSquare

fun main(args: Array<String>) {
//    val name = "Madrigal"
//    var healthPoints = 89
//    var isBlessed = true
//    val isImmortal = false

    /*val player = Player("Madrigal", 89, true, false)
    player.castFireball()*/

//    var currentRoom = TownSquare()/*Room("Foyer")*/
    /*println(currentRoom.description())
    println(currentRoom.load())*/

//    var townSquare = TownSquare()
    /*var className = when(townSquare) {
        is TownSquare -> "TownSquare"
        is Room -> "Room"
        else -> throw IllegalArgumentException()
    }*/

    // Aura
//    var auraColor = player.auraColor()
    //    println(auraColor)

    //  com.bignerdranch.nyethack.Player status
//    var healthStatus = formatHealthStatus(healthPoints, isBlessed)
//    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)
//    printPlayerStatus(player)

    Game.play()

    //Aura
//    player.auraColor()
/*val race = "gnome"
    val faction = when(race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        //个人感觉可以类似switch else就是default 但是必须写
        else -> ""
    }*/
//    castFireball(5)
}

/*private fun printPlayerStatus(
    player: Player
    *//*auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String*//*
) {
    println(
        "(Aura：${player.auraColor()})" +
                "(Blessed:${if (player.isBlessed) "YES" else "NONE"})"
    )

    println("${player.name} ${player.formatHealthStatus()}")
}*/

/*
private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "Green" else "None"
*/

/*private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    var auraVisible = isBlessed && healthPoints > 50 || isImmortal
    *//*if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }*//*
    var auraColor = if (auraVisible) "GREEN" else "None"
    return auraColor
}*/

/*private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when(healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly"
        } else {
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }*/
/*private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    var healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly"
        } else {
            "has some minor wounds"
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"

    }
    *//*var healthStatus =  if (healthPoints == 100) {
//        println(name + " is in excellent condition!")
    "is in excellent condition!"
} else if (*//**//*healthPoints >= 90*//**//*healthPoints in 90..99) {
//        println("$name has a few scratches.")
        "has a few scratches."
    } else if(*//**//*healthPoints >= 75*//**//*healthPoints in 75..89) {
        if (isBlessed) {
//            println("$name has some minor wounds but is healing quite quickly")
        "has some minor wounds but is healing quite quickly"
        } else {
//            println("$name has some minor wounds.")
        "has some minor wounds"
        }
    } else if (*//**//*healthPoints >= 15*//**//*healthPoints in 15..74) {
//        println("$name looks pretty hurt.")
    "looks pretty hurt."
    } else {
//        println("$name is in awful condition!")
    "is in awful condition!"
    }*//*
    return healthStatus
}*/

//private fun castFireball() {
/*
private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")
*/

/*Math.random()*10*numFireballs
var drunkenState = when(castFireball) {
    in 1..10 -> "tipsy"
    in 11..20 -> "sloshed"
    in 21..30 -> "soused"
    in 31..40 -> "stewed"
    else -> "..t0aSt3d"
}*/
/*
private fun castFireball(numFireballs: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}*/

object Game {
    private val player = Player("Madrigal"/*, 89, true, false*/)
    private var currentRoom: Room = TownSquare()/*Room("Foyer")*/

    private var worldMap = listOf(
            listOf(currentRoom, Room("Tavern"), Room("Back Room")),
            listOf(Room("Long Corridor"), Room("Generic Room"))
            )

    init {
        println("Welcome, adventurer.")
        player.castFireball()

    }

    fun play() {
        while (true) {
            //Play NyetHack

            println(currentRoom.description())
            println(currentRoom.load())

            //player status
            printPlayerStatus(player)

            print("> Enter your command: ")
//            println("Last command: ${readLine()}")
//            println(GameInput(readLine()).processCommand())

            val commandState = readLine()
            println(GameInput(commandState).processCommand())
            if (GameInput(commandState).stop()) {
                break
            }
        }
    }

    private fun printPlayerStatus(
        player: Player
        /*auraColor: String,
        isBlessed: Boolean,
        name: String,
        healthStatus: String*/
    ) {
        println(
            "(Aura：${player.auraColor()})" +
                    "(Blessed:${if (player.isBlessed) "YES" else "NONE"})"
        )

        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            in listOf("quit", "exit") -> bye()
            "map" -> drawMap()
            "ring" -> ringBell()
            else -> commandNotFound()
        }

        fun stop() = command ==  "quit" || command == "exit"

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)

            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }

    private fun bye() = "Goodbye!"

    private fun drawMap() {
        var mapTmp = arrayOfNulls<Array<String>>(worldMap.count())
        var index = 0
        var notInRoom = "0"
        var inRoom = "X"
        while (index < worldMap.count()) {
            mapTmp[index] = Array(worldMap[index].count()) {notInRoom}
            index++
        }
        mapTmp[player.currentPosition.y]?.set(player.currentPosition.x, inRoom)

        for (each in mapTmp) {
            if (each != null) {
                for (eachOne in each) {
                    print("$eachOne ")
                }
            }
            println()
        }
    }

    fun ringBell() = "ring ring ring!"
}
