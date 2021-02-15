package com.satelite54.mykotlin.Basic

import java.util.*

fun main() {
    val x = 1
    val rand = Random()

    when(rand.nextInt(2)) {
        1 -> println(x)
        2 -> println(x)
        else -> {
            println("x is not 1, 2")
        }
    }

    var res = when(rand.nextInt(100)) {
        100 -> "A"
        90 -> "B"
        80 -> "C"
        else -> "F"
    }
    println(res)

    when (rand.nextInt(3)) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }
    var ren = rand.nextInt(4)
    when (ren) {
        Integer.parseInt(ren.toString()) -> println("encodes ren")
        1 + 3 -> println("4")
        else -> println("s dose not encode")
    }

    val vaildNumbers = listOf(3, 6 , 9)
    when (3) {
        in vaildNumbers -> println("x id valid")
        in 1..10 -> println("x is in the range")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }

    var xy: Any;
    xy = 1;
    var bool = when {
        xy is Any -> println("xy = Any")
        if(xy == 1) true else false -> println(true);
        else -> println("else")
    }
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}