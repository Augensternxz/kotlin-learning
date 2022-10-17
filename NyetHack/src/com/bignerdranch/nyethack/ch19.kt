package com.bignerdranch.nyethack

fun main() {
    //19.6
    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
    val res = flipValues(gradesByStudent)
    println(gradesByStudent)
    println(res)

    // 7 在Tavern
    // 8
    val valuesToAdd = listOf(1,18,73,3,44,6,1,33,2,22,5,7)
    val sum = valuesToAdd.filter { it >= 5 }
                         .chunked(2) {
                             it.reduce { acc, i -> acc * i }
                         }
                         .fold(0) { acc, i ->
                             acc + i
                         }
    println(sum)

}

fun<T,R> flipValues(map: Map<T,R>) : Map<R,T> {
    return map.values.zip(map.keys).toMap()


}