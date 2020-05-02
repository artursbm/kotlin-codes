package dev.kotlin.declarations

typealias EmployeeSet = MutableSet<Employee>

fun main() {
    // val == final, which means that this variable will assume only one value in its entire scope.
    // var == any other variable, so I declare it to assume any value within its type.
    // val number3 would give an error, because at this point, Kotlin compiler doesn't know of which type number3 is.
    val number = 25 // in this case, the compiler knows that the variable number is an Int
    val number2: Int
    val number4: Int = 26 // this is possible but it's redundant, because kotlin is good on inferring primitive types and explicit casts
    // So, kotlin is capable to infer types, and this is good to reduce the amount of code written. I don't need to do as in number4.
    // However, sometimes, we want to explicitly give a type to a variable, because it's not that obvious to the compiler:
    val number5: Short =
        13 // this will make kotlin not infer that number5 is an Int, instead it will type it as a Short.

    var variableNumber = number
    variableNumber = number5.toInt()

    var y: String = "Must give a type or a value when initializing variables in Kotlin"
    var x = 12


    println("variableNumber $variableNumber")
    println("$y. x = $x")

    val employee1 = Employee("Artur Mello", 1234)
    employee1.name = "Artur Soares"

    val employees: EmployeeSet = mutableSetOf()
    employees.add(employee1)

    println(employees.toList()[0].name)

}
