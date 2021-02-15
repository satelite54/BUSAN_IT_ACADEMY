package com.satelite54.mykotlin.Basic

fun main() {
    var array: Array<String> = arrayOf("코틀린", "강좌")
    println(array.get(0))
    println(array[0])
    println(array.size)

    val b = Array(5, {i -> i .toString()})

    val a= arrayOf("0", "1", "2","3")

    for(c in a) {
        print(c)
    }
    println()
    for(c in b) {
        print(c)
    }
}