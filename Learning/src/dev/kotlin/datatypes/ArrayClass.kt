package dev.kotlin.datatypes

/*
* Every Array in Kotlin is a class, and it always extends Collection interface.
* An array can be of any element type, and is initialized by arrayOf()
* */
fun main() {

    val arrayOfInts = arrayOf(1, 2, 3, 4)
    val arrayOfLongs = arrayOf(1L,2L)
    val arrayOfLongs2 = arrayOf<Long>(1,2,3)
    val arrayOfArrays = arrayOf(arrayOfInts, arrayOfLongs, arrayOfLongs2)
    // just a chained forEach snippet, to get the idea of how to make forEach call
    arrayOfArrays.forEach{ arr ->
        arr.forEach { el ->
            println(el)
        }
    }

    // now, to initialize the array with some logic, do the following:
    val arrayInit = Array(20) {n -> (n*2) + 1}
    // prints the element at 0: n = 0 -> element = (0*2) + 1 = 1
    println(arrayInit[0])
    // prints the element at 4: n = 9 -> element = (4*2) + 1 = 9
    println(arrayInit[4])

    // primitive array implementation (there is IntArray, CharArray, BooleanArray, primitive array for every primitive type.
    val intArray = IntArray(4)
    intArray.forEach {
        println(it)
    }


}