package com.satelite54.mykotlin.Basic

fun main() {
    val a: Int = 1
    // val b: Long = a//오류
    val b: Long = a.toLong()
    // println(a == b) // 오류
    val i: Byte = b.toInt().toByte()
}