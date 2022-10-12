package com.bignerdranch.nyethack
import com.sun.xml.internal.bind.v2.runtime.Coordinator
import java.io.File

class Player(_name: String,
            override var healthPoints: Int = 100,
            var isBlessed: Boolean,
            var isImmortal: Boolean) : Fightable {

    override val diceCount: Int = 3
//        get() = TODO("Not yet implemented")
    override val diceSides: Int = 6
//        get() = TODO("Not yet implemented")

    override fun attack(opponent: Fightable): Int {
//        TODO("Not yet implemented")
        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }


    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown = selectHometown()
//    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)

    init {
        require(healthPoints > 0) { "healthPoints must be greater than zero" }
        require(name.isNotBlank()) { "Player must have a name" }
    }

    constructor(name: String) : this(name,
//            healthPoints = 100,
            isBlessed = true,
            isImmortal = false)

    /*var healthPoints = _healthPoints
    var isBlessed = _isBlessed
    private val isImmortal = _isImmortal*/

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    fun auraColor() =
        if (isBlessed && healthPoints > 50 || isImmortal) "Green" else "None"


    fun formatHealthStatus() =
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
        }

    private fun selectHometown() = File("NyetHack/data/towns.txt")
        .readText()
        .split("\r\n")
        .shuffled()
        .first()

    //延迟初始化
    lateinit var alignment: String

    fun determineFate() {
        alignment = "Good"
    }
    fun proclaimFate() {
        if (::alignment.isInitialized) println(alignment)
    }
}

