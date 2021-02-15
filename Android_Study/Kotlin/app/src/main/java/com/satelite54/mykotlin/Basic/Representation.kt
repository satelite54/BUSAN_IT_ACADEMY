package com.satelite54.mykotlin.Basic

fun main() {
    //jvm primitive
    val a: Int = 100
    println(a === a)

    //Boxed
    val boxedA: Int? = a
    val anoterBoxedA: Int? = a
    println("==: ${boxedA == anoterBoxedA}")
    println("===: ${boxedA === anoterBoxedA}")
}