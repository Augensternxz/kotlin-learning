fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false
    var auraVisible = isBlessed && healthPoints > 50 || isImmortal
    /*if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }*/
    val karma = (Math.pow(Math.random(),(110-healthPoints)/100.0)*20).toInt()
    var auraColor = when(karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        else -> "green"
    }
//    println(auraColor)

        /*var healthStatus =  if (healthPoints == 100) {
    //        println(name + " is in excellent condition!")
            "is in excellent condition!"
        } else if (*//*healthPoints >= 90*//*healthPoints in 90..99) {
//        println("$name has a few scratches.")
        "has a few scratches."
    } else if(*//*healthPoints >= 75*//*healthPoints in 75..89) {
        if (isBlessed) {
//            println("$name has some minor wounds but is healing quite quickly")
        "has some minor wounds but is healing quite quickly"
        } else {
//            println("$name has some minor wounds.")
        "has some minor wounds"
        }
    } else if (*//*healthPoints >= 15*//*healthPoints in 15..74) {
//        println("$name looks pretty hurt.")
    "looks pretty hurt."
    } else {
//        println("$name is in awful condition!")
    "is in awful condition!"
    }*/


    var healthStatus = when(healthPoints) {
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

    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor) -> $name $healthStatus"
    println(statusFormatString)
    println("(Aura：$auraColor)" +
            "(Blessed:${if (isBlessed) "YES" else "NONE"})")

    println("$name $healthStatus")
    /*val race = "gnome"
    val faction = when(race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        //个人感觉可以类似switch else就是default 但是必须写
        else -> ""
    }*/

}