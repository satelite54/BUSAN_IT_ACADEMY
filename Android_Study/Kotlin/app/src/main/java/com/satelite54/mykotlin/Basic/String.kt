package com.satelite54.mykotlin.Basic

fun main() {
    var x = "Kotlin"
    println(x.get(0))
    println(x[0])
    println(x.length)

    for(c in x) {
        println(c)
    }

    var y = """
        dkdwkjdkwd \n
    """.trimIndent()

    println(y)
}