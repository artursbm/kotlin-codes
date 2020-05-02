package dev.kotlin.challenges

fun main() {
    // Declare non-null float variable with value -3847.384 in 2 ways
    val v1 = -3847.384f
    val v2: Float = -3847.384f
//    val v3 = (-3847.384).toFloat() too verbose

    // Change both declarations above to nullable
    val v3: Float? = -3847.384f

    // declare array of non-nullable Short and size 5; assign values 1 to 5 to it
    val shortArray = shortArrayOf(1, 2, 3, 4, 5)
//    Another correct option
    val shortArray2: Array<Short> = arrayOf(1, 2, 3, 4, 5) // generic array declaration

    // Declare an array of nullable Ints and put values from 5 to 200, with intervals of 5 (5,10,15,20...)
    val bigArray = Array<Int?>(40) { i -> (i + 1) * 5 }

    // Suppose we have a Java method which is declared like:
    // public void method1(char[] charArray).
    // Declare an array that can be passed to this method and insert values 'a', 'b' and 'c'
    val charArray = charArrayOf('a', 'b', 'c') // this will declare a CharArray, which in JVM gets interpreted as char[]

    // given this variable:
    val x: String? = "I AM IN UPPERCASE"
    // Using one line of code, declare another variable, assign x.toLowerCase() to it when x isn't null,
    // and the string "I give up!" when x is null
    val newString = x?.toLowerCase() ?: "I give Up!"

    // Now use the let lambda function to (a) lowercase the string, and (b) replace "am" with "am not"
    val newString2 = x?.let { it.toLowerCase().replace("am", "am not") }
    // my answer works, but a better way is as above
//    val newString2 = x.let {
//        val newVal = it?.replace("AM", "am not")
//        newVal?.toLowerCase()
//    } ?: "I give Up!"

}