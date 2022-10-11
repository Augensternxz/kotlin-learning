package com.bignerdranch.nyethack

//重写equals和hashcode
open class Weapon(val name: String, val type: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Weapon

        if (name != other.name) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}


//代数数据类型

/*enum*/ sealed class StudentStatus {
    object NotEnrolled : StudentStatus()
    class Active(val courseId: String) : StudentStatus()
    object Graduated : StudentStatus()
}

class Student(var status: StudentStatus) {
    fun studentMessage(status: StudentStatus): String {
        return when(status) {
            is StudentStatus.Active -> "Welcome, student!"
            is StudentStatus.NotEnrolled -> "Please choose a course!"
            is StudentStatus.Graduated -> "Congratulations!"
        }
    }
}

fun main() {
    var student = Student(StudentStatus.Active("Kotlin101"))
    println(student.studentMessage(student.status))

    var listMultidimensional = listOf( listOf(1,2,3),
                                    listOf(4,5))
    var listTest = listMultidimensional.toTypedArray()
    for(each in listTest) {
        println(each)
    }
}

