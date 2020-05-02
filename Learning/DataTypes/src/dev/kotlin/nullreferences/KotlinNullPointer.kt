package dev.kotlin.nullreferences

fun main() {
    // Kotlin makes it difficult to get a null pointer exception
    val x: String? = null
    // using x?.someMethod() is to use a safe call operator
    println(x?.toUpperCase() ?: "X")

    // str doesn't need to be nullable type, which means it can hold null value from another nullable variable.
    // it makes necessary to safe check null result, and it's possible also to make elvis operator call
    // other way is to just use the elvis operator on the declaration, and then just ensuring non null on the
    // variable calls
    val str = x ?: "to be null or not to be null..."
    println(str.toUpperCase())

    val arr: Any = arrayOf(1, 2, 3, 4)
    val s = arr as? String
    // if I do safe casting above, I NEED TO SAFE CHECK the variable as below (?.)
    println(s?.toUpperCase() ?: "THIS IS OTHER DATA, NOT A STRING!!!")

    // let function: is used to substitute !!. chained call, and to ensure nullable values to be used as args within
    // a non-nullable method param (see fun printAnswer() that receives a non-nul arg, but y will be nullable
    var y: Int? = null
    println("Is there an answer for this question?")
    y?.let {
        printAnswer(it)
    }
    y = 10
    println("How much is 5 + 5?")
    // This is good practice to avoid null pointers
    y?.let {
        printAnswer(it)
    }

}

fun printAnswer(ans: Int) {
    println("The answer is $ans")
}
