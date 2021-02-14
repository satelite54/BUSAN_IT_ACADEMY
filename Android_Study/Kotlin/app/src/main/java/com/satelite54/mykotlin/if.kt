package com.satelite54.mykotlin

fun main() {
    val a = 1;
    val b = 2;
    val max1 = if (b > a) a else b

    val max2 = if (b > a) {
        print("Choose b")
        b
    } else {
        print("Choose a")
        a
    }
}