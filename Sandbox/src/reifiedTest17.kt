inline fun <reified T> randomOrBackupLoot(backupLoot: () -> T): T {
    val items = listOf(Coin(14), Fedora("a fedora of the ages", 150))
    val randomLoot: Loot = items.shuffled().first()
    return if (randomLoot is T) {
        randomLoot
    } else {
        backupLoot()
    }
}

fun main(args: Array<String>) {
    randomOrBackupLoot {
        Fedora("a backup fedora", 15)
    }.run {
        // Prints either the backup fedora or the fedora of the ages
        println(name)
    }
}