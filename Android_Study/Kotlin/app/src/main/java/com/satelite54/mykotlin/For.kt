package com.satelite54.mykotlin

fun main() {

    val list = listOf(1, 2, 3, 4, 5)
    for(item in list) {
        println(item)
    }
    println()

    val myData = MyData()
    for(item in myData) {
        print(item)
    }

    val array = arrayOf("가", "나", "다")
    for(i in array.indices) {
        println("$i: ${array.get(i)}")
    }

    for((idx, value) in array.withIndex()) {
        println("$idx: ${value}")
    }
}

class MyData {
    operator fun iterator(): MyIterator {
        return MyIterator()
    }
}

class MyIterator {
    val data = listOf(1, 2, 3, 4, 5)
    var idx = 0
    operator fun hasNext(): Boolean {
        return data.size > idx
    }
    operator fun next(): Int {
        return data[idx++]
    }
}