package dev.kotlin.declarations

/*
* @author Artur Mello
*
* Refence vs.Structural equality check on objects
* In Kotlin, it works with the two operands "==" and "===".
* The first one (==) compares for structural equality (same data).
* The second one (===) compares if the variables references the same object.
*
* The same goes to != and !==
* */
fun main() {
    val employee1 = Employee("Artur", 1)
    val employee2 = Employee("Artur", 1)
    val employee3 = Employee("Paula", 2)
    val employee4 = employee1

    println(employee1 == employee2)
    println(employee1 == employee3)
    println(employee2 == employee3)
    println(employee1 === employee2)
    println(employee1 === employee3)
    println("employee1 and employee4 are the same object: ${employee1 === employee4}")
    println("employee's 1 name is ${employee1.name}")
    println(employee1.equals(employee3))
    println(employee1.equals(employee2))

//    Now about casting objects and smart casting:
    val emp: Any = employee1
    if(emp is Employee) {
//        val newEmp = emp as Employee ----> this is not necessary because smart casting does the cast automatically
//        this happens because the comparison 'emp is Employee' assumes that emp is an Employee within the if scope.
        emp.name = "Judy"
        println(emp)
    }

}

class Employee(var name: String, val id: Int) {

    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }
        return false
    }
}