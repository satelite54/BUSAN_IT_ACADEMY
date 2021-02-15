package com.satelite54.mykotlin.Basic

import java.lang.StringBuilder
//
//val cnt = 0;
//
//var cnt2 = 0;
//var cnt3:Float = 1.032342f;
//var cnt4:Double = 1.3872198739218;

fun main() {
    var x = 3;
    if (x in 1..10)
        println(x);
    x = 5
    for(x in 1..5) {
        println(x)
    }

    val items = listOf("apple", "banana, kiwi")
    for(item in items) {
        println(item)
    }

    if ("apple" in items) {
        println("apple")
    }

    items.filter { it.startsWith("a") } // 람다식을 이용해서 컬렉션에 filter map 연산 가능하다.
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach {println(it)}
}

//fun sum(a:Int, b: Int): Int {
//    return a + b
//}
//
//fun maxOf1(a:Int, b:Int) = if(a > b) a else b
//
//fun maxOf2(a:Int, b:Int): Int { //리턴 타입 추론
//    if(a > b)
//        return a
//    else
//        return b
//}

fun unionString(str1:String?, str2:String?) {
    if(str1 != null && str2 != null) {
        println(str1 + str2)
    } else {
        println("${str1}이나 ${str2}는 문자열이 아닙니다.")
    }
}

fun getStringLength(obj: Any): Int? {
    if(obj is String) {// 자바의 instanceof 키워드와 is가 비슷한 역할을 하지만 조건이 맞을 경우 자동으로 형변환 해줌
        // 자바에서는 명시적으로 (String)obj와같이 형변환을 해주어야하나 코틀린에서는 그럴 필요없다.
        return obj.length
    }
    return null;
}

fun printStringList(list: List<String>, idx: Int) {
    var index = idx;
    while (index < list.size) {
        println("item at $index is ${list[index]}")//리스트를 배열에 접근하듯 접근할 수 있다.
        index++
    }
}

fun descibe(obj: Any): String =
    when (obj) {
        1 -> {
            if(obj is String) {
                println("dwdaw")
                obj
            }
            else
                "String이 아님"
        }
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }

