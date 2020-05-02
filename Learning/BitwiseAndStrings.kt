package dev.kotlin.declarations

fun main() {

    val x = 0x00010
    val y = 0x00100
//    bitwise operands are spelled, not symbols like x | y, x & y, x ^ y...
    println(x or y)
    println(x and y)
    println(x xor y)
    val money = 10.00
    val change = 1.23
    println("Your change is $$change")
    println("Kotlin knows that \$change is the name of the variable")
    println("Kotlin knows that $change is the value of the variable")

//    Triple quote strings: """ """ makes the string accept natural text, without having to scape special chars
    val path = "C:\\someDir\\someDir2" // this is ok because using one ", I have to put \\
//    val path2 = "C:\someDir\someDir2" // this will create a problem because compiler thinks I want to write scace \s
    val pathTripleQuote = """C:\someDir\someDir2"""

    val check = """So, at the table, the woman paid the check 
                    |with a U$$money bill. The problem is that
                    |I didn't have the change, because it was 
                    |U$$change, and the lack of 1 cent coin 
                    |didn't allow me to give it to her. I had
                    |to accept this minor loss, and their order
                    |that cost US${money - change} was free of charge""".trimMargin()
//    the trimMargin() automatically trims the text to correct its indent within a triple quote string.
//    without it, the margin from the second to the final line of text will be tabbed.
//    I can choose which symbol represents the margin trim (using trimMargin(\*), for instance)
//    but the standard is the | symbol, and we don't need to put it.

}