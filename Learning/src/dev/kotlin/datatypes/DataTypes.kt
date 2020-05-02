package dev.kotlin.datatypes

fun main() {
    val myInt = 13
    // I can use the L suffix to indicate a Long number
    var myLong = 1234L

//    myLong = myInt // this isn't allowed, since Kotlin doesn't widen types automatically.
    myLong = myInt.toLong() // Kotlin needs to have the method to explicitly do it
    val myByte: Byte = 102
    println(myByte)
    myLong = myByte.toLong()

    // Double is the default data type for floating numbers
    val myDouble = 12.13
    // I can use an f suffix to indicate float type
    var myFloat = 13.12f

    println("The data Type is Double? ${myDouble is Double};")
    println("The data Type is Float? ${myFloat is Float};")
    // converting double to float. is also possible to do the inverse, convert float to double (same to Int/Long etc.)
    myFloat = myDouble.toFloat()

    val myChar = 'c'
    println(myChar)
    val myCharAscii = 67.toChar()
    println(myCharAscii)
    println("What is faster than light in vacuum?")
    fasterThanLight()

}

// use Nothing to indicate something that REALLY does not have any value. Indicates reaaaaally nothing
// Use Unit to indicate Void, which means a singleton that returns a class that holds no value of interest
// Any is like the root class for ALL objects in Kotlin (like in Java).
fun fasterThanLight(): Nothing {
    throw NullPointerException("Nothing is faster than speed of light!")
}