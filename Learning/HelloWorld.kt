package academy.kotlin.helloworld

// Kotlin tries to reduce the amount of code written in a file, and for that, it imports automatically in all kotlin
// files the most used packages, which happens to be inside kotlin-stdlib (Kotlin Standard Library).
// Thus, Kotlin imports 10 packages by default.

// Kotlin can be coded in file or class.
// To run Kotlin, we need to bundle the Kotlin Runtime Environment alongside the JRE, because Kotlin standard libraries
// are included only in the Kotlin Runtime Environment.

// kotlin accepts code to be written outside a class, but when the program is compiled, kotlin compiler encapsulates the
// (top-level) function inside an implicit class.
fun main() {
    print("Hello, World!")
}