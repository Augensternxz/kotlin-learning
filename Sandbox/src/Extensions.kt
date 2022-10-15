
val String.numVowels
        get() = count { "aeiouy".contains(it) }


fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> /*Any*/T.easyPrint() /*= println(this)*/: /*Any*/T {
    println(this)
    return this
}

infix fun String?.printWithDefault(default: String) = print(this ?: default)

fun main() {
//    println("Madrigal has left the building".addEnthusiasm())
    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()

    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default string"

/*infix 关键字适用于有单个参数的扩展和类函数，可以让你以更简洁的语法调用函数。
如果一个函数定义使用了 infix 关键字，那么调用它时，
接收者和函数之间的点操作符以及参数的一对括号都可以不要。
以下是 printWithDefault 函数 infix 版本和非 infix 版本的调用：
null printWithDefault "Default string" // With infix
null.printWithDefault("Default string") // Without infix*/
}